package org.mum.scrum.web.controllers;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.mum.scrum.entities.*;
import org.mum.scrum.services.ProjectService;
import org.mum.scrum.services.TimelogService;
import org.mum.scrum.services.UserService;
import org.mum.scrum.services.UserStoryService;
import org.mum.scrum.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@PreAuthorize("hasRole('Developer')")
public class DeveloperController {
	
	@Autowired
	private UserStoryService userStoryService;
	
	@Autowired
	private TimelogService timelogService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	private String userEmail;
	@ModelAttribute("userstory")
	public Userstory getUserStory() {
		return new Userstory();
	}
	
	@ModelAttribute("projects")
	public List<Project> getAllProjects() {
		return projectService.findAll();
	}
	
	@RequestMapping(value = "/developer", method=RequestMethod.GET)
	public String get(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		userEmail = userDetail.getUsername();
		model.addAttribute("userstories", userStoryService.getAllUserStoriesByEmail(userEmail));
		return "developer";
	}
	
	@RequestMapping(value = "/developerUS/{id}/edit", method=RequestMethod.GET)
	public String editDeveloperUserStory(Model model, @PathVariable("id") String id) {
		try{
			int usId = Integer.parseInt(id);
			Userstory userstory = userStoryService.getUserStoryById(usId);
			Timelog timelog = timelogService.findByUserstoryIdAndUpdatedDate(usId, new Date());
			if(timelog == null)
			{
				timelog = new Timelog();
				timelog.setUserstory(userstory);
			}
			model.addAttribute("timelog", timelog);	
		}catch(Exception e){
			throw new ResourceNotFoundException();
		}
		
		return "editDeveloper";
	}
	
	@RequestMapping(value = "/developerUS/{id}/edit", method = RequestMethod.POST)
	public String saveDeveloperUserStory(Timelog timelog, @PathVariable("id") String id) {
		
		try{
			int usId = Integer.parseInt(id);
			Userstory userStory = userStoryService.getUserStoryById(usId);
			timelog.setUserstory(userStory);
			timelog.setUserId(userService.findUserByEmail(userEmail).getId());
			
			timelog.setUpdatedDate(new Date());
			timelogService.save(timelog);
			userStory.setCompletedTime(timelog.getDuration());
			
			userStoryService.updateUserStory(userStory);
		}catch(Exception e){
			throw new ResourceNotFoundException();
		}
		
		return "redirect:/developer";
	}
	
	public int getCompletedTime(Set<Timelog> timelogs)
	{
		return timelogs.stream().mapToInt(Timelog::getDuration).sum();
	}
}

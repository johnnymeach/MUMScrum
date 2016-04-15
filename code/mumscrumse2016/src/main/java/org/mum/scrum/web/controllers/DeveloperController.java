package org.mum.scrum.web.controllers;

import java.util.Date;

import org.mum.scrum.entities.*;
import org.mum.scrum.services.TimelogService;
import org.mum.scrum.services.UserService;
import org.mum.scrum.services.UserStoryService;
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
	
	private String userEmail;
	@ModelAttribute("userstory")
	public Userstory getUserStory() {
		return new Userstory();
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
	public String editDeveloperUserStory(Model model, @PathVariable("id") int id) {
		Timelog timelog = new Timelog();
		timelog.setUserstory(userStoryService.getUserStoryById(id));
		model.addAttribute("timelog", timelog);	
		return "editDeveloper";
	}
	
	@RequestMapping(value = "/developerUS/{id}/edit", method = RequestMethod.POST)
	public String saveDeveloperUserStory(Timelog timelog, @PathVariable("id") int id) {
		timelog.setUserstory(userStoryService.getUserStoryById(id));
		timelog.setUserId(userService.findUserByEmail(userEmail).getId());
		timelog.setUpdatedDate(new Date());
		timelogService.save(timelog);
		return "redirect:/developer";
	}
}

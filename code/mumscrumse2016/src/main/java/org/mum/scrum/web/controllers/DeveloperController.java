package org.mum.scrum.web.controllers;

import java.util.Set;

import org.mum.scrum.entities.*;
import org.mum.scrum.services.TimelogService;
import org.mum.scrum.services.UserService;
import org.mum.scrum.services.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
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
	
//	@ModelAttribute("timelog")
//	public Timelog getTimeLog() {
//		return new Timelog();
//	}
	
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
		Userstory userstory = userStoryService.getUserStoryById(id);
		
		Timelog timelog = new Timelog();
		timelog.setUserstory(userstory);
		User user = userService.findUserByEmail(userEmail);
		timelog.setUserId(user.getId());
		
		model.addAttribute("timelog", timelog);
		return "editDeveloper";
	}
	
	@RequestMapping(value = "/developerUS/{id}/edit", method = RequestMethod.POST)
	public String saveDeveloperUserStory(Timelog timelog) {
		//timelogService.save(timelog);
//		Userstory userstory = userStoryService.getUserStoryById(id);
//		Set<Timelog> timelogs = userstory.getTimelogs();
//		timelogs.add(timelog);
//		//userstory.setTimelogs(timelogs);
//		userStoryService.updateUserStory(userstory); 
		return "redirect:/developer";
	}
}

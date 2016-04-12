package org.mum.scrum.web.controllers;

import org.mum.scrum.entities.*;
import org.mum.scrum.services.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@ModelAttribute("userstory")
	public Userstory getUserStory() {
		return new Userstory();
	}
	
	@RequestMapping(value = "/developer", method=RequestMethod.GET)
	public String get(Model model) {
		model.addAttribute("userstories", userStoryService.getAllUserStoriesByUserId(1));
		return "developer";
	}
	
	@RequestMapping(value = "/developerUS/{id}/edit", method=RequestMethod.GET)
	public String editDeveloperUserStory(Model model, @PathVariable("id") int id) {
		Userstory userstory = userStoryService.getUserStoryById(id);
		model.addAttribute("userstory", userstory);
		return "editDeveloper";
	}
	
	@RequestMapping(value = "/developerUS/{id}/edit", method = RequestMethod.POST)
	public String saveDeveloperUserStory(Userstory userStory) {
		userStoryService.updateUserStory(userStory); 
		return "redirect:/developer";
	}
}

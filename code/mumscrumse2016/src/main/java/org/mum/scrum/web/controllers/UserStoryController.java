package org.mum.scrum.web.controllers;

import javax.validation.Valid;

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
@PreAuthorize("hasRole('System Admin')")
public class UserStoryController {
	
	@Autowired
	private UserStoryService userStoryService;
	
	@ModelAttribute("userstory")
	public Userstory getUserStory() {
		return new Userstory();
	}
	
	@RequestMapping(value="/backlogs", method=RequestMethod.POST)
	public String add(Userstory userStory) {
		userStoryService.addUserStory(userStory);
		return "redirect:/backlogs";
	}
	
	@RequestMapping(value="/backlogs", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("userstories", userStoryService.getAllUserStories());
		return "userStory";
	}
	
	@RequestMapping(value="/backlogs/product/{product}", method=RequestMethod.GET)
	public String get(@PathVariable Project product, Model model) {
		model.addAttribute("userstories", userStoryService.getAllUserStories(product));
		return "redirect:/backlogs";
	}
	
	@RequestMapping(value="/backlogs/product/{product}/sprint/{sprint}", method=RequestMethod.GET)
	public String get(@PathVariable Project product, @PathVariable Sprint sprint, Model model) {
		model.addAttribute("userstories", userStoryService.getAllUserStories(product, sprint));
		return "redirect:/backlogs";
	}
	
	// to-do other get methods
	
	@RequestMapping(value="/backlogs/update", method=RequestMethod.POST)
	public String update(Userstory userStory) {
		userStoryService.updateUserStory(userStory); 
		return "redirect:/backlogs";
	}
	
	@RequestMapping(value="/backlogs/delete/{userstoryId}", method=RequestMethod.POST)
	public String delete(int userstoryId) {
		userStoryService.deleteUserStoryById(userstoryId);
		return "redirect:/backlogs";
	}
}

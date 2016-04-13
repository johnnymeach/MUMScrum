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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasAnyRole('Scrum Master')")
public class UserStoryController {
	
	@Autowired
	private UserStoryService userStoryService;
	
	@ModelAttribute("userstory")
	public Userstory getUserStory() {
		return new Userstory();
	}
	
	@RequestMapping(value="/backlogs", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("userstories", userStoryService.getAllUserStories());
		return "userStory";
	}
	
	@RequestMapping(value = "/createuserstory", method = RequestMethod.GET)
	public String createUserStory() {
		ModelAndView model = new ModelAndView();
		model.setViewName("createUserStory");
		return "createUserStory";
	}
	
	@RequestMapping(value="/createuserstory", method=RequestMethod.POST)
	public String add(Userstory userStory) {
		userStoryService.addUserStory(userStory);
		return "redirect:/backlogs";
	}
	
	@RequestMapping(value="/backlogs/{id}/edit", method=RequestMethod.GET)
	public String editUserStory(Model model, @PathVariable("id") int id) {
		Userstory userstory = userStoryService.getUserStoryById(id);
		model.addAttribute("userstory", userstory);
		return "editUserStory";
	}
	
	@RequestMapping(value = "/backlogs/{id}/edit", method = RequestMethod.POST)
	public String saveEditedUserStory(Userstory userStory) {
		userStoryService.updateUserStory(userStory); 
		return "redirect:/backlogs";
	}
	
	@RequestMapping(value="/backlogs/deleteUserStory", method=RequestMethod.POST)
	public String delete(@RequestParam(value = "userStoryId") int userstoryId) {
		userStoryService.deleteUserStoryById(userstoryId);
		return "redirect:/backlogs";
	}
}

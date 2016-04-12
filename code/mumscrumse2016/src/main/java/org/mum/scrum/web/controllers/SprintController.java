
package org.mum.scrum.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.mum.scrum.entities.Sprint;
import org.mum.scrum.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasRole('Scrum Master')")
public class SprintController {
	@Autowired
	private SprintService sprintService;

	@ModelAttribute("sprint")
	public Sprint Constructor() {
		return new Sprint();
	}
	
	
	/*@ModelAttribute("currentUser")
	public User getCurrentUser()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    if (principal instanceof UserDetails) 
	    {
	    	String email = ((UserDetails) principal).getUsername();
	    	User loginUser = sprintService.findUserByEmail(email);
	    	return new SecurityUser(loginUser);
	    }

	    return null;
	}*/


	@RequestMapping(value = "/createsprint", method = RequestMethod.GET)
	public ModelAndView createSprint() {

		ModelAndView model = new ModelAndView();
		model.setViewName("newsprint");

		return model;
	}

	@RequestMapping(value = "/createsprint", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("sprint") Sprint sprint, BindingResult result, Principal principal,
			Model model, @RequestParam(value = "projectId") int projectId) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "newsprint";
		}
		
		// Trim the white space of sprint info
		sprint.setName(sprint.getName().trim());

		sprintService.save(sprint);

		return "redirect:/";
	}

	@RequestMapping(value = "/sprint", method = RequestMethod.GET)
	public String listSprint(Model model) {
		List<Sprint> listSprint = sprintService.findAll();
		model.addAttribute("sprints", listSprint);
		return "listsprint";
	}

	@RequestMapping(value = "/sprint/{id}/edit", method = RequestMethod.GET)
	public String editUser(Model model, @PathVariable("id") int id) {

		Sprint sprint = sprintService.findSprintByID(id);
		model.addAttribute("sprint", sprint);
		return "editsprint";
	}

	@RequestMapping(value = "/sprint/{id}/edit", method = RequestMethod.POST)
	public String saveEditedSprint(Model model, Sprint sprint, @PathVariable("id") int id) {

		Sprint editedSprint = sprintService.findSprintByID(id);
		editedSprint.setName(sprint.getName());
		editedSprint.setDescription(sprint.getDescription());
		editedSprint.setProject(sprint.getProject());
		sprintService.save(editedSprint);
		return "redirect:/";
	}

	
	@RequestMapping(value = "/deletesprint", method = RequestMethod.POST)
	public String deletUser(Model model, @RequestParam(value = "sprintId") int sprintId) {

		sprintService.deleteSprint(sprintId);
		return "redirect:/";
	}
	

}

package org.mum.scrum.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.mum.scrum.entities.Project;
import org.mum.scrum.entities.User;
import org.mum.scrum.services.UserService;
import org.mum.scrum.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ProjectController {
	@Autowired
	private ProjectService pm;
	@Autowired
	private UserService adminManager;
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET)
	public String project(Model model, @PathVariable("id") int id) {
		Project p = pm.findProjectByID(id);
		model.addAttribute("project", p);
		return "project";

	}
	@RequestMapping(value = "/createproject", method = RequestMethod.GET)
	public ModelAndView createproject() {

		ModelAndView model = new ModelAndView();
		model.setViewName("createproject");
		List<User> users = adminManager.findAll();
		model.addObject("users", users);
		return model;

	}
	@RequestMapping(value = "/createproject", method = RequestMethod.POST)
	public String createproject(@Valid @ModelAttribute("project") Project p, BindingResult result, Principal principal,
			Model model) {
		pm.save(p);
		return "redirect:/projectlist";
	}
	@RequestMapping(value = "/projectlist", method = RequestMethod.GET)
	public ModelAndView projectlist() {

		ModelAndView model = new ModelAndView();
		model.setViewName("projectlist");
		List<Project> projects = pm.findAll();
		model.addObject("projects", projects);
		return model;

	}
	@RequestMapping(value = "/projectdelete/{id}", method = RequestMethod.GET)
	public String projectdelete(Model model, @PathVariable("id") int id) {
		pm.deleteProjectByID(id);
		return "redirect:/projectlist";

	}
}

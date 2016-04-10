
package org.mum.scrum.web.controllers;

import java.util.List;

import org.mum.scrum.entities.Project;
import org.mum.scrum.entities.User;
import org.mum.scrum.services.IAdmin;
import org.mum.scrum.services.IProject;
import org.mum.scrum.services.ProjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasRole('System Admin')")
public class ProjectController {
	@Autowired
	private IProject pm;
	@Autowired
	private IAdmin adminManager;
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public ModelAndView project() {

		ModelAndView model = new ModelAndView();
		model.setViewName("project");
		List<Project> projects = pm.findAll();
		model.addObject("projects", projects);
		List<User> users = adminManager.findAll();
		model.addObject("users", users);
		return model;

	}

}

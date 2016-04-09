
package org.mum.scrum.web.controllers;

import java.util.List;

import org.mum.scrum.services.ProjectManager;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasRole('System Admin')")
public class ProjectController {

	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public ModelAndView createUser() {

		ModelAndView model = new ModelAndView();
		model.setViewName("project");
		List projects = ProjectManager.getAllProjects();
		model.addObject("projects", projects);
		return model;

	}

}

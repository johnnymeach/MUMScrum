
package org.mum.scrum.web.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasRole('System Admin')")
public class UserController {

	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public ModelAndView createUser() {

		ModelAndView model = new ModelAndView();
		model.setViewName("newuser");

		return model;

	}
	
	@RequestMapping(value = "/listuser", method = RequestMethod.GET)
	public ModelAndView listUser() {

		ModelAndView model = new ModelAndView();
		model.setViewName("listuser");

		return model;

	}

}

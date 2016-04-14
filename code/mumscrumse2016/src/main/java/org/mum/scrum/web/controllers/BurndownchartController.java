package org.mum.scrum.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.mum.scrum.entities.*;
import org.mum.scrum.services.*;
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

public class BurndownchartController {
	@Autowired
	private ProjectService pm;
	@Autowired
	private SprintService sprintService;
	@Autowired
	private UserStoryService usService;
	
	@RequestMapping(value = "/burndownchart", method = RequestMethod.GET)
	public ModelAndView burndownchartlist() {
		ModelAndView model = new ModelAndView();
		model.setViewName("burndownchart");
		List<Sprint> list = sprintService.findAll();
		Sprint s = list.get(0);
		model.addObject("sprints", list);
		model.addObject("selectedId", s.getId());
		return model;
	}
	
	@RequestMapping(value = "/burndownchart/{id}", method = RequestMethod.GET)
	public String burndownchart(Model model, @PathVariable("id") int id) {
		List<Sprint> list = sprintService.findAll();
		model.addAttribute("sprints", list);
		model.addAttribute("selectedId", id);
		return "burndownchart";

	}
}

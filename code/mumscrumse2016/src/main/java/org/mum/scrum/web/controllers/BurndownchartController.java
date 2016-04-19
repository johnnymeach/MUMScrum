package org.mum.scrum.web.controllers;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

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
		if(list.size() > 0){
			Sprint s = list.get(0);
			model.addObject("sprints", list);
			model.addObject("selectedId", s.getId());
			List<Integer> tl = sprintService.getRemainingTimeList(s);
			String tls = this.listToString(tl);
			model.addObject("timelist", tls);

			List<Integer> etl = sprintService.getExpectedTimeList(s);
			String etls = this.listToString(etl);
			model.addObject("expectedtimelist", etls);
			
			List<String> tll = sprintService.getRemainingTimeLabelList(s);
			String tlls = this.listToString(tll);
			model.addObject("timelabellist", tlls);
		}
		return model;
	}
	private  <T> String  listToString(List<T> tl){
		String tls = "[";
		for(int i = 0; i < tl.size(); i++){
			T ti = tl.get(i);
			if(ti instanceof Integer){
				tls = tls + tl.get(i);
			}else{
				tls = tls + "'" + tl.get(i) + "'";
			}
			
			if(i == tl.size() - 1){
			
			}else{
				tls = tls + ",";
			}
			
		}
		tls = tls + "]";
		return tls;
	}
	@RequestMapping(value = "/burndownchart/{id}", method = RequestMethod.GET)
	public String burndownchart(Model model, @PathVariable("id") int id) {
		List<Sprint> list = sprintService.findAll();
		model.addAttribute("sprints", list);
		model.addAttribute("selectedId", id);
		Sprint s = sprintService.findSprintByID(id);
		if(s != null){
			List<Integer> tl = sprintService.getRemainingTimeList(s);
			String tls = this.listToString(tl);
			model.addAttribute("timelist", tls);
			
			List<Integer> etl = sprintService.getExpectedTimeList(s);
			String etls = this.listToString(etl);
			model.addAttribute("expectedtimelist", etls);

			List<String> tll = sprintService.getRemainingTimeLabelList(s);
			String tlls = this.listToString(tll);
			model.addAttribute("timelabellist", tlls);
		}
		return "burndownchart";

	}
}

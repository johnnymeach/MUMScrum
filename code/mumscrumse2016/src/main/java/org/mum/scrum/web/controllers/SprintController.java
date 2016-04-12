
package org.mum.scrum.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.mum.scrum.entities.Project;
import org.mum.scrum.entities.Sprint;
import org.mum.scrum.services.ProjectService;
import org.mum.scrum.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

	@Autowired
	private ProjectService projectService;

	@ModelAttribute("sprint")
	public Sprint Constructor() {
		return new Sprint();
	}

	@ModelAttribute("projects")
	public List<Project> getAllProject() {
		return sprintService.getAllProject();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, "startDate", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "endDate", new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/createsprint", method = RequestMethod.GET)
	public String createSprint() {

		return "newsprint";
	}

	@RequestMapping(value = "/createsprint", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("sprint") Sprint sprint, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "newsprint";
		}

		// Trim the white space of sprint info
		sprint.setName(sprint.getName().trim());
		sprintService.save(sprint);

		return "redirect:/sprint";
	}

	@RequestMapping(value = "/sprint", method = RequestMethod.GET)
	public String listSprint(Model model) {
		List<Sprint> listSprint = sprintService.findAll();
		model.addAttribute("sprints", listSprint);
		return "listsprint";
	}

	@RequestMapping(value = "/sprint", method = RequestMethod.POST)
	public String listSprintByProject(Model model, @RequestParam(value = "projectId") int projectId) {
		/*
		 * if (projectId > 0) { Project project =
		 * projectService.findProjectByID(projectId); List<Sprint> listSprint =
		 * sprintService.findSprintByProject(project);
		 * model.addAttribute("sprints", listSprint); } else { List<Sprint>
		 * listSprint = sprintService.findAll(); model.addAttribute("sprints",
		 * listSprint); }
		 */
		Project project = projectService.findProjectByID(projectId);
		List<Sprint> listSprint = sprintService.findSprintByProject(project);
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
		return "redirect:/sprint";
	}

	@RequestMapping(value = "/deletesprint", method = RequestMethod.POST)
	public String deletSprint(@RequestParam(value = "sprintId") int sprintId) {

		sprintService.deleteSprint(sprintId);
		return "redirect:/sprint";
	}

}

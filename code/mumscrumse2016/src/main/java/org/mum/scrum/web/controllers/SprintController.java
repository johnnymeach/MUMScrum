
package org.mum.scrum.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.mum.scrum.entities.Project;
import org.mum.scrum.entities.Sprint;
import org.mum.scrum.services.ProjectService;
import org.mum.scrum.services.SprintService;
import org.mum.scrum.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "/deletesprint", method = RequestMethod.POST)
	public String deletSprint(@RequestParam(value = "sprintId") int sprintId) {

		sprintService.deleteSprint(sprintId);
		return "redirect:/sprint";
	}
	

	@RequestMapping(value = "/sprint/{id}/edit", method = RequestMethod.GET)
	public String editUser(Model model, @PathVariable("id") String id) {

		try{
			int sId = Integer.parseInt(id);
			Sprint sprint = sprintService.findSprintByID(sId);
			model.addAttribute("sprint", sprint);
		}catch(Exception e){
			throw new ResourceNotFoundException();
		}
		
		return "editsprint";
	}

	@RequestMapping(value = "/sprint/{id}/edit", method = RequestMethod.POST)
	public String saveEditedSprint(Model model, Sprint sprint, @PathVariable("id") int id) {

		Sprint editedSprint = sprintService.findSprintByID(id);
		editedSprint.setName(sprint.getName());
		editedSprint.setStartDate(sprint.getStartDate());
		editedSprint.setEndDate(sprint.getEndDate());
		editedSprint.setDescription(sprint.getDescription());
		editedSprint.setProject(sprint.getProject());
		sprintService.save(editedSprint);
		return "redirect:/sprint";
	}
	
	@RequestMapping(value = "/sprint/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Sprint>> listSprintByProject(@PathVariable("id") String projectId) {

		List<Sprint> listSprint;
		try{
			int pId = Integer.parseInt(projectId);
			Project project = projectService.findProjectByID(pId);
			if(project == null){
				listSprint = sprintService.findAll();
			}else{
				listSprint = sprintService.findSprintByProject(project);
			}
		}catch(Exception e){
			throw new ResourceNotFoundException();
		}
		
		
		return new ResponseEntity<List<Sprint>>(listSprint, HttpStatus.OK);
	}

}

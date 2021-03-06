
package org.mum.scrum.services;

import java.util.List;

import org.mum.scrum.entities.Project;
import org.mum.scrum.entities.Sprint;

public interface SprintService {

	public List<Sprint> findAll();
	
	public Sprint findSprintByID(int id);
	
	public List<Sprint> findSprintByProject(Project project);
	
	public List<Sprint> findSprintByProjectId(int projectId);
	
	public void save(Sprint sprint);
	
	public void deleteSprint(int id);
	
	public List<Project> getAllProject();
	
	public List<Integer> getRemainingTimeList(Sprint s);
	public List<String> getRemainingTimeLabelList(Sprint s);
	public List<Integer> getExpectedTimeList(Sprint s);
}


package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.dao.ProjectDao;
import org.mum.scrum.dao.RoleDao;
import org.mum.scrum.dao.UserStoryDao;
import org.mum.scrum.dao.SprintDao;
import org.mum.scrum.entities.Project;
import org.mum.scrum.entities.Sprint;
import org.mum.scrum.entities.Userstory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SprintServiceImpl implements SprintService
{
	@Autowired
	private UserStoryDao userstoryRepository;
	
	@Autowired
	private SprintDao sprintRepository;

	@Autowired
	private ProjectDao projectRepository;
	
	@Override
	public List<Sprint> findAll() {
		
		return sprintRepository.findAll();
	}
	
	@Override
	public Sprint findSprintByID(int id) {
		
		return sprintRepository.findOne(id);
	}
	
	@Override
	public void save(Sprint sprint) {
		
		sprintRepository.save(sprint);
	}

	@Override
	public void deleteSprint(int id) {
		
		sprintRepository.delete(id);
	}

	@Override
	public List<Project> getAllProject() {
		
		return projectRepository.findAll();
	}

	@Override
	public List<Sprint> findSprintByProject(Project project) {
		
		return sprintRepository.findByProject(project);
	}
	
	@Override
	public List<Sprint> findSprintByProjectId(int id) {
		
		return sprintRepository.findByProjectId(id);
	}
	
	protected int getTotalEstimateTime(Sprint s){
//		List<Userstory> list = userstoryRepository.findAllBySprintId(s.getId());
		return 0;
	}
	protected int getLoggedTimeByDate(Sprint s, String date){
		return 0;
	}
	protected int getRemainingTimeByDate(Sprint s, String date){
		return 0;
	}
	
	public List<Integer> getRemainingTimeList(Sprint s){
		List<Integer> list = null;
		return list;
	}
}


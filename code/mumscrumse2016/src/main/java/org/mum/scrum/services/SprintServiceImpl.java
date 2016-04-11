
package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.dao.ProjectDao;
import org.mum.scrum.dao.RoleDao;
import org.mum.scrum.dao.SprintDao;
import org.mum.scrum.entities.Sprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SprintServiceImpl implements SprintService
{
	
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

	
	
}


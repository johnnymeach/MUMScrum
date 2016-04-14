package org.mum.scrum.dao;

import java.util.List;

import org.mum.scrum.entities.Project;
import org.mum.scrum.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintDao extends JpaRepository<Sprint, Integer> {

	public List<Sprint> findByProject(Project project);
	
	public List<Sprint> findByProjectId(int id);
}

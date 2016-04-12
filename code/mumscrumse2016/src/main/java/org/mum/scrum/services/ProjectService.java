package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.entities.Project;
import org.mum.scrum.entities.Sprint;

public interface ProjectService {
	public List<Project> findAll();
	public void save(Project p);
	public Project findProjectByID(int id);
}

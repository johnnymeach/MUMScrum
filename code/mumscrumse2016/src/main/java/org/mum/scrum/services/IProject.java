package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.entities.Project;

public interface IProject {
	public List<Project> findAll();
	public void save(Project p);
}

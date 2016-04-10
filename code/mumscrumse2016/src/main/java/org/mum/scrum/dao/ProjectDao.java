package org.mum.scrum.dao;

import org.mum.scrum.entities.Project;
import org.mum.scrum.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project,Integer> {
	Project findByName(String name);
}
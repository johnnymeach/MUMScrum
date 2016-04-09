package org.mum.scrum.dao;

import java.util.List;

import org.mum.scrum.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project,Integer> {
	  List<Project> findAll();
}
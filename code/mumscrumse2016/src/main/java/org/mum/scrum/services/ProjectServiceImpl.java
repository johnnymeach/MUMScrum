package org.mum.scrum.services;

import java.util.List;

import org.mum.scrum.dao.*;
import org.mum.scrum.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectDao projectRepository;
	@Override
	public List<Project> findAll(){
		return projectRepository.findAll();
	}
	@Override
	public void save(Project p){
		projectRepository.save(p);
	}
	@Override
	public Project findProjectByID(int id) {
		return projectRepository.findOne(id);
	}
	public void deleteProjectByID(int id){
		projectRepository.delete(id);
	}
}

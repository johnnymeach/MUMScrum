package org.mum.scrum.services;

import java.util.ArrayList;
import java.util.List;

import org.mum.scrum.dao.*;
import org.mum.scrum.entities.*;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectManager {
	@Autowired
	private static ProjectDao pdao;
	public static List<Project> getAllProjects() {
		List<Project> ret = pdao.findAll();
		return ret;
	}
}

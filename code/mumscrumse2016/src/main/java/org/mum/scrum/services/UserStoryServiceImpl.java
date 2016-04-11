package org.mum.scrum.services;

import java.util.List;

import org.mum.scrum.dao.UserStoryDao;
import org.mum.scrum.entities.Project;
import org.mum.scrum.entities.Sprint;
import org.mum.scrum.entities.User;
import org.mum.scrum.entities.Userstory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserStoryServiceImpl implements UserStoryService {

	@Autowired
	private UserStoryDao userStoryRepository;
	
	@Override
	public void addUserStory(Userstory userStory) {
		userStoryRepository.save(userStory);
	}

	@Override
	public Userstory getAllUserStoryById(int id) {
		return userStoryRepository.findOne(id);
	}

	@Override
	public List<Userstory> getAllUserStories() {
		return userStoryRepository.findAll();
	}

	@Override
	public List<Userstory> getAllUserStories(Project project) {
		//to-do
		return userStoryRepository.findBySprint(null);
	}

	@Override
	public List<Userstory> getAllUserStories(Project project, Sprint sprint) {
		// to-do
		return userStoryRepository.findBySprint(sprint);
	}

	@Override
	public List<Userstory> getAllUserStories(Project project, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Userstory> getAllUserStories(Project project, Sprint sprint, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserStory(Userstory userStory) {
		userStoryRepository.save(userStory);
	}

	@Override
	public void deleteUserStoryById(int id) {
		userStoryRepository.delete(id);
	}

	@Override
	public void deleteUserStories(List<Userstory> userStories) {
		userStoryRepository.delete(userStories);
	}

}

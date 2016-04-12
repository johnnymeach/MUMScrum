package org.mum.scrum.services;

import java.util.List;

import org.mum.scrum.entities.*;

public interface UserStoryService {
	
	public void addUserStory(Userstory userStory);
	
	public Userstory getUserStoryById(int id);
	public List<Userstory> getAllUserStories();
	public List<Userstory> getAllUserStories(Project project);
	public List<Userstory> getAllUserStories(Project project, Sprint sprint);
	public List<Userstory> getAllUserStories(Project project, User user);
	public List<Userstory> getAllUserStories(Project project, Sprint sprint, User user);
	
	public void updateUserStory(Userstory userStory);
	
	public void deleteUserStoryById(int id);
	public void deleteUserStories(List<Userstory> userStories);
}

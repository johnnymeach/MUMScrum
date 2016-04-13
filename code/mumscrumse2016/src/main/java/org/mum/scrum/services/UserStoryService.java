package org.mum.scrum.services;

import java.util.List;

import org.mum.scrum.entities.*;

public interface UserStoryService {
	
	public void addUserStory(Userstory userStory);
	
	public Userstory getUserStoryById(int id);
	public List<Userstory> getAllUserStories();
	public List<Userstory> getAllUserStoriesByUserId(int userId);
	
	public void updateUserStory(Userstory userStory);
	
	public void deleteUserStoryById(int id);
}

package org.mum.scrum.dao;

import java.util.List;

import org.mum.scrum.entities.*;
import org.mum.scrum.entities.Userstory;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;

public interface UserStoryDao extends JpaRepository<Userstory, Integer>{
	List<Userstory> findBySprint(Sprint sprint);
	List<Userstory> findByUser(User user);
	List<Userstory> findBySprintAndUser(Sprint sprint, User user);
	
	//Userstory findUserStoryById(Integer id);
	
//	@Modifying
//	@Query("update Userstory us set us.name = ?1, us.description = ?2 where us.id = ?2")
//	int setNameAndDescriptionByUserStoryId(String name, String description, Integer userStoryId);
}

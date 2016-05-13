package org.mum.scrum.dao;

import java.util.List;
import org.mum.scrum.entities.Userstory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoryDao extends JpaRepository<Userstory, Integer>{
	List<Userstory> findByUserId(Integer userId);
	List<Userstory> findBySprintId(Integer sprintId);
	List<Userstory> findByUserEmail(String email);
}

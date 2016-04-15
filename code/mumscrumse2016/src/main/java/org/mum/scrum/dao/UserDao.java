package org.mum.scrum.dao;

import java.util.List;

import org.mum.scrum.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	List<User> findByRoleId(int id);
}

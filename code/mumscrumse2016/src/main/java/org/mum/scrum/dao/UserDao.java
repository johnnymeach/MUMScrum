package org.mum.scrum.dao;

import org.mum.scrum.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {

	User findByEmail(String email);

}

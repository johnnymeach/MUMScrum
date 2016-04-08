package org.mum.scrum.repositories;



import org.mum.scrum.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,String> {

//	User findEmployeeByEmail(String email);	
	
}


package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.entities.Role;
import org.mum.scrum.entities.User;

public interface UserService {

	public List<User> findAll();
	
	public User findUserByID(int id);
	public void save(User user);

	public User findUserByEmail(String email);
	
	public List<User> getAvailableDeveloper();

	public Set<User> getAvailableTester();

	public User updateUser(User user);
	
	public void deleteUser(int id);
	
	public List<Role> getAllRole();

}

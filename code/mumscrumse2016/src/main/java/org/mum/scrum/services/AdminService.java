
package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.entities.Role;
import org.mum.scrum.entities.User;

public interface AdminService {

	public List<User> findAll();

	public void save(User user);

	public User findUserByEmail(String email);

	public Set<User> getAvailableDeveloper();

	public Set<User> getAvailableTester();

	public User updateUser(User user);
	
	public List<Role> getAllRole();

}

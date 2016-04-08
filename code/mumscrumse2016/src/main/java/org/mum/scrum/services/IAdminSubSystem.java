/**
 * 
 */
package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.entities.User;
import org.mum.scrum.entities.Role;


/**
 * @author Sam
 *
 */
public interface IAdminSubSystem 
{
	
	public List<User> findAll();

	public User createUser(User user);

	public User findUserByEmail(String email);

	public Set<User> getAvailableDeveloper();
	
	public Set<User> getAvailableTester();
	
	public User updateUser(User user);


	
}


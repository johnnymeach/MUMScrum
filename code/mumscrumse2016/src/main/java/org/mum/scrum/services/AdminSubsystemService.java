/**
 * 
 */
package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.entities.User;
import org.mum.scrum.entities.Role;
import org.mum.scrum.repositories.UserRepository;
import org.mum.scrum.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Sam
 *
 */
@Service
@Transactional
public class AdminSubsystemService implements IAdminSubSystem
{
	//private UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public Set<User> getAvailableDeveloper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<User> getAvailableTester() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}


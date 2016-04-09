
package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.entities.User;
import org.mum.scrum.dao.RoleDao;
import org.mum.scrum.dao.UserDao;
import org.mum.scrum.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService implements IAdmin
{
	
	@Autowired
	private UserDao userRepository;

	@Autowired
	private RoleDao roleRepository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
		userRepository.save(user);
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

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}
	
	
}


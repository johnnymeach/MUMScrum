
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
public class UserServiceImpl implements UserService
{
	
	@Autowired
	private UserDao userRepository;

	@Autowired
	private RoleDao roleRepository;
	
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	
	@Override
	public User findUserByID(int id) {
		
		return userRepository.findOne(id);
	}
	
	@Override
	public void deleteUser(int id) {
		
		userRepository.delete(id);
	}

	@Override
	public void save(User user) {
		
		userRepository.save(user);
	}

	@Override
	public User findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
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

	@Override
	public List<User> getAvailableDeveloper() {
		return userRepository.findByRoleId(1);
	}	
}


/**
 * 
 */
package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.entities.User;
import org.mum.scrum.entities.EmployeeRole;
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
	private UserRepository employeeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	/*
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	*/
	@Override
	public List<User> findAll() {
		//return userDao.findAll();
		return employeeRepository.findAll();
	}

	@Override
	public User createEmployee(User user) {
		//return userDao.create(user);
		return employeeRepository.save(user);
	}


//	public User login(String email, String password) {
//		//return userDao.login(email,password);
//		//return userRepository.login(email,password);
//		return userRepository.findByEmailAndPassword(email,password);
//	}

	@Override
	public User updateEmployee(User user) {
		return employeeRepository.save(user);
	}

//	public void deleteUser(int id) {
//		userRepository.delete(id);
//	}

	@Override
	public User findUserByEmail(String email) {
		return employeeRepository.findEmployeeByEmail(email);
	}

	@Override
	public User findEmployeeByUserName(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(id);
	}

	@Override
	public Set<Role> findRoleByStatus(Byte status) {
		// TODO Auto-generated method stub
		return roleRepository.findByStatus((byte) 1);
	}

	@Override
	public Role findRoleByID(int id) {
		return roleRepository.findOne(id);
	}

	@Override
	public Set<Role> findRoleNotExistInEmployee(String username) {
		return roleRepository.findNotExistInEmployee(username);
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
	public Set<EmployeeRole> findEmployeeRoleByEmployee(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveEmployeeRole(EmployeeRole employeeRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeRole findEmployeeRoleByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


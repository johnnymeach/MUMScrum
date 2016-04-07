/**
 * 
 */
package org.mum.scrum.services;

import java.util.List;
import java.util.Set;

import org.mum.scrum.entities.User;
import org.mum.scrum.entities.EmployeeRole;
import org.mum.scrum.entities.Role;


/**
 * @author Sam
 *
 */
public interface IAdminSubSystem 
{
	
	public List<User> findAll();

	public User createEmployee(User user);

	public User findEmployeeByUserName(String id);

	public Set<User> getAvailableDeveloper();
	
	public Set<User> getAvailableTester();
	
	public User updateEmployee(User user);

//	public void deleteUser(int id) {
//		userRepository.delete(id);
//	}

	public User findUserByEmail(String email);
	
	public Set<Role> findRoleByStatus(Byte status);
	
	public Role findRoleByID(int id);
	
	public Set<Role> findRoleNotExistInEmployee(String username);
	
	public Set<EmployeeRole> findEmployeeRoleByEmployee(String username);
	
	public void saveEmployeeRole(EmployeeRole employeeRole);
	
	public EmployeeRole findEmployeeRoleByID(int id);
	
	
}


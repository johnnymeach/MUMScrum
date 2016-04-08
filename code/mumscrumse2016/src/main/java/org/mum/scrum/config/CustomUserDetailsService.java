/**
 * 
 */
package org.mum.scrum.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.mum.scrum.services.IAdminSubSystem;


@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private IAdminSubSystem hrService;
	
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		return null;
		
//		org.mum.scrum.entities.User user = hrService.findEmployeeByUserName(username);
//		if(user==null) throw new UsernameNotFoundException("user not found!");
////		List<GrantedAuthority> authorities = buildUserAuthority(hrService.findEmployeeRoleByEmployee(username));
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		return buildUserForAuthentication(user, authorities);
//		user.setEmployeeRoles(user.getEmployeeRoles());
//		return new SecurityUser(user);
		
	}

	// Converts com.pru.pruquote.model.User user to
	// org.springframework.security.core.u0000-00-00serdetails.User
//	private User buildUserForAuthentication(org.mum.scrum.entities.Users user, List<GrantedAuthority> authorities) {
////		
//		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, !user.isLocked(), authorities);
//	}

//	private List<GrantedAuthority> buildUserAuthority(Set<EmployeeRole> userRoles) {

//		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//		// Build user's authorities
//		for (EmployeeRole userRole : userRoles) {	
////			Set<RolePermission> rolePermissions=securityService.rolePermissionFindByRoleNotDelete(userRole.getRole().getRoleId());
////			for(RolePermission rolePermission : rolePermissions){
//				setAuths.add(new SimpleGrantedAuthority(userRole.getRole().getRoleName()));
////			}
//		}
//
//		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
//
//		return Result;
//	}

}

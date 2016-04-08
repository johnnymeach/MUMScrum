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
	private IAdminSubSystem adminService;
	
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {		
		
		org.mum.scrum.entities.User user = adminService.findUserByEmail(email);
		if(user==null) throw new UsernameNotFoundException("user not found!");
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
		return buildUserForAuthentication(user, authorities);

		
	}

	// Converts com.pru.pruquote.model.User user to
	// org.springframework.security.core.u0000-00-00serdetails.User
	private User buildUserForAuthentication(org.mum.scrum.entities.User user, List<GrantedAuthority> authorities) {
//		
		return new User(user.getEmail(), user.getPassword(), user.getStatus(), true, true, true, authorities);
	}


}

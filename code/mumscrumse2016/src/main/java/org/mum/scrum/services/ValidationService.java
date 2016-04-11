
package org.mum.scrum.services;

import org.mum.scrum.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ValidationService {

	public boolean checkAuthority(String auth) {
		Authentication auths = SecurityContextHolder.getContext().getAuthentication();
		return auths.getAuthorities().contains(new SimpleGrantedAuthority(auth));
	}
}

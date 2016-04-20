package org.mum.scrum;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mum.scrum.entities.User;
import org.mum.scrum.services.UserService;
import org.mum.scrum.web.config.WebMvcConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WebMvcConfig.class)
@WebAppConfiguration
public class TestUserService {
	@Autowired
	private UserService userService;
	
	@Test
	public void readUserByEmail() {
		User user = userService.findUserByEmail("meachsokly@gmail.com");
		assertNotNull(user);
	}
	

}


package org.mum.scrum.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.mum.scrum.entities.Role;
import org.mum.scrum.entities.User;
import org.mum.scrum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasRole('System Admin')")
public class UserController {
	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User Constructor() {
		return new User();
	}

	@ModelAttribute("roles")
	public List<Role> getAllRole() {
		return userService.getAllRole();
	}
	
	/*@ModelAttribute("role")
	private String getUserRole(){
		return "System Administrator";
	}*/

	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public ModelAndView createUser() {

		ModelAndView model = new ModelAndView();
		model.setViewName("newuser");

		return model;
	}

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, Principal principal,
			Model model, @RequestParam(value = "confirmpassword") String confirmPassword) {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "newuser";
		}

		if (!user.getPassword().equals(confirmPassword)) {
			ObjectError error = new ObjectError("confirmpassword", "Your password does not match!");
			result.addError(error);
			model.addAttribute("errors", result.getAllErrors());
			return "newuser";
		}

		// Encode password before saving into the database
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		// Trim the white space of user firstname, lastname
		user.setFirstName(user.getFirstName().trim());
		user.setLastName(user.getLastName().trim());

		userService.save(user);

		return "redirect:/";
	}

	@RequestMapping(value = "/listuser", method = RequestMethod.GET)
	public String listUser(Model model) {
		List<User> listUser = userService.findAll();
		model.addAttribute("users", listUser);
		return "listuser";
	}

	@RequestMapping(value = "/user/{id}/edit", method = RequestMethod.GET)
	public String editUser(Model model, @PathVariable("id") int id) {

		User user = userService.findUserByID(id);
		model.addAttribute("user", user);
		return "edituser";
	}

	@RequestMapping(value = "/user/{id}/edit", method = RequestMethod.POST)
	public String saveEditedUser(Model model, User user, @PathVariable("id") int id) {

		User editedUser = userService.findUserByID(id);
		editedUser.setFirstName(user.getFirstName());
		editedUser.setLastName(user.getLastName());
		editedUser.setEmail(user.getEmail());
		editedUser.setRole(user.getRole());
		userService.save(editedUser);
		return "redirect:/";
	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	public String resetPassword(Model model, @RequestParam(value = "newpassword") String newPwd,
			@RequestParam(value = "userId") int userId) {

		User editedUser = userService.findUserByID(userId);

		// Encode password before saving into the database
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		editedUser.setPassword(encoder.encode(newPwd));
		userService.save(editedUser);
		
		return "redirect:/user/"+userId+"/edit";
	}
	
	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public String deletUser(Model model, @RequestParam(value = "userId") int userId) {

		userService.deleteUser(userId);
		return "redirect:/";
	}
	

}

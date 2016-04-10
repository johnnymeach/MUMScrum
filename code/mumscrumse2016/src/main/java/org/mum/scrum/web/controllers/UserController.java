
package org.mum.scrum.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.mum.scrum.entities.Role;
import org.mum.scrum.entities.User;
import org.mum.scrum.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasRole('System Admin')")
public class UserController {
	@Autowired
	private AdminService adminService;
	
	@ModelAttribute("user")
	public User Constructor(){
    	return new User();
    }
	@ModelAttribute("roles")
	public List<Role> getAllRole(){
		return adminService.getAllRole();
	}
	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public ModelAndView createUser() {

		ModelAndView model = new ModelAndView();
		model.setViewName("newuser");

		return model;
	}
	
	@RequestMapping(value="/createuser",method=RequestMethod.POST)
	public String addNewUser(@Valid @ModelAttribute("user") User user
			,BindingResult result,Principal principal,Model model,@RequestParam(value="confirmpassword") String confirmPassword){
		
		if(result.hasErrors()){
			model.addAttribute("errors", result.getAllErrors());
			return "newuser";			
		}
		
		if(!user.getPassword().equals(confirmPassword)){
			ObjectError error = new ObjectError("confirmpassword","Your password does not match!");
			result.addError(error);
			model.addAttribute("errors", result.getAllErrors());
			return "newuser";	
		}
		
		// Encode password before saving into the database
		PasswordEncoder encoder=new BCryptPasswordEncoder();
	    user.setPassword(encoder.encode(user.getPassword()));
	    
	    // Trim the white space of user firstname, lastname
	    user.setFirstName(user.getFirstName().trim());
	    user.setLastName(user.getLastName().trim());
	    
		adminService.save(user);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/listuser", method = RequestMethod.GET)
	public String listUser(Model model) {
		List<User> listUser = adminService.findAll();
		model.addAttribute("users", listUser);
		return "listuser";
	}

}

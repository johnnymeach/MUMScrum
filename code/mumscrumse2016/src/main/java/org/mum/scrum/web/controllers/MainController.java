package org.mum.scrum.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.mum.scrum.services.IAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
			
	@Autowired
	private IAdmin adminService;
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException() {
        return "404";
    }
	@RequestMapping(value =  "/", method = RequestMethod.GET)
	public ModelAndView defaultPage() {				
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;

	}
	
	@RequestMapping(value =  "/404", method = RequestMethod.GET)
	public ModelAndView pageNotFound() {		
		ModelAndView model = new ModelAndView();
		model.setViewName("404");
		return model;
	}
	
	@RequestMapping(value =  "/keep-alive", method = RequestMethod.POST)
	@ResponseBody
	public String keepAlive() {		
		return "true";
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model,
			@RequestParam(value="expired",required=false) String expire, HttpServletRequest request) {
		
//		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(!SecurityContextHolder.getContext().getAuthentication().getName().
				  equals("anonymousUser"))
			return "redirect:/";
		
		if (error != null) {
			model.addAttribute("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		
		if (expire != null) {
			if(expire.equals("1"))
				model.addAttribute("expire", "Account has been log in at other place!, please login again!");
			else
				model.addAttribute("expire", "Session expired, please login again!");
		}		

		return "login";

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else if (exception instanceof AccountExpiredException) {
			error = exception.getMessage();
		} else if (exception instanceof DisabledException) {
			error = exception.getMessage();
		}
		else {
			error = exception.getMessage();
		
		}

		return error;
	}

	// for 403 access denied page	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}	
	
	@RequestMapping(value =  "/changepwd", method = RequestMethod.GET)
	public ModelAndView changePwd() {		
		ModelAndView model = new ModelAndView();
		model.setViewName("changepwd");
		return model;
	}
	
//	@Transactional
//	@RequestMapping(value =  "/changepwd", method = RequestMethod.POST)	
//	public String processChangePassword(@RequestParam String oldpwd,@RequestParam String newpwd,Model model,Principal principal) {
//		if(oldpwd.isEmpty() || newpwd.isEmpty()){
//			model.addAttribute("error","Invalid password and new password");
//			return "changepwd";
//		}
//		if(checkPassword(oldpwd, principal)=="false"){
//			model.addAttribute("error","Current Password is not correct");
//			return "changepwd";
//		}
//		
//		User user=hrService.findEmployeeByUserName(principal.getName());				
//		
//		
//		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();		
//		user.setPassword(encoder.encode(newpwd));
//
//		Calendar cal = Calendar.getInstance(); 
//		cal.add(Calendar.MONTH, 3);
//		Date pwdEx=new Date();
//	    pwdEx=cal.getTime();
//	    user.setPwdExpiredDate(pwdEx);
//	    user.setSynDate(new Date());
//	    user.setOperator(principal.getName());
//	    user.setFirstLogin(false);
//	    hrService.updateEmployee(user);	    	   
//		
//	    model.addAttribute("success","Password change successfully!");
//		return "changepwd";
//	}
//	
//	@RequestMapping(value =  "/check-password", method = RequestMethod.POST)
//	@ResponseBody
//	public String checkPassword(@RequestParam String password,Principal principal) {		
//		
//		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//		User user=hrService.findEmployeeByUserName(principal.getName());
//		Boolean isMatch=encoder.matches(password, user.getPassword());
//		return isMatch.toString();
//	}
}
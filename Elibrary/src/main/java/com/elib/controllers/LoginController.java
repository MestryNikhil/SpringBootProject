package com.elib.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model,String error,String logout) {
		if(error != null) 
			model.addAttribute("error","Provided username and password are invalid");
		
		if(logout !=null) 
			model.addAttribute("message","You have been logged out successfully! ");
		
		return "login";	
		
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping("/adminHome")
	public String adminHome(HttpServletRequest req) {
		req.setAttribute("mode", "Admin_Home");
		return "welcome";
		
	}
	@RequestMapping("/librarianHome")
	public String libHome(HttpServletRequest req) {
		req.setAttribute("mode", "Librarian_Home");
		return "welcome";
		
	}

}

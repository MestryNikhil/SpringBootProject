package com.elib.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.elib.models.Librarian;
import com.elib.services.LibServices;

@Controller
@RequestMapping("/admin")
public class Admincontroller {
	@Autowired
	private LibServices libServices;
	
	
	
	@RequestMapping("/addLibrarian")
	public String addlib(HttpServletRequest req){
		req.setAttribute("mode", "NewLib");
		return "addlibrarian";
		
		}
	@PostMapping("/saveLibrarian")
	public String savelib(@ModelAttribute Librarian lib,BindingResult result,HttpServletRequest req) {
		if(result.hasErrors()) {
		System.out.println(result.getAllErrors());
		}
		libServices.saveLibrarian(lib);
		req.setAttribute("Libs", libServices.findAllLibs());
		req.setAttribute("mode", "ViewLib");
		return "addlibrarian";
	}
	@RequestMapping("/deleteLibrarian")
	public String deletelib(@RequestParam("id") int id,HttpServletRequest req) {
		libServices.deleteLibrarian(id);
		req.setAttribute("Libs", libServices.findAllLibs());
		req.setAttribute("mode", "ViewLib");
		return "addlibrarian";
	}
	@RequestMapping("/viewLibrarian")
	public String viewlib(HttpServletRequest req) {
		req.setAttribute("Libs", libServices.findAllLibs());
		req.setAttribute("mode", "ViewLib");
		return "addlibrarian";
	}
	@RequestMapping("/editLibrarian")
	public String editlib(@RequestParam int id,HttpServletRequest req) {
		req.setAttribute("Lib", libServices.findOneLib(id));
		req.setAttribute("mode", "EditLib");
		return "addlibrarian";
	}
}

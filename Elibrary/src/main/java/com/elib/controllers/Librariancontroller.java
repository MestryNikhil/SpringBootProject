package com.elib.controllers;




import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elib.models.Book;
import com.elib.models.IssueBook;
import com.elib.models.Student;
import com.elib.services.Bookservices;
import com.elib.services.IssueServices;
import com.elib.services.StudServices;

@Controller
@RequestMapping("/librarian")
public class Librariancontroller {
	@Autowired
	private Bookservices bookservices;
	@Autowired
	private StudServices studServices;
	@Autowired
	private IssueServices issueServices;


	
	@RequestMapping("/addBook")
	public String addbook(HttpServletRequest req){
		req.setAttribute("mode", "NewBook");
		return "addbooks";
		
		}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute Book book,BindingResult result,HttpServletRequest req) {
		bookservices.saveBook(book);
		req.setAttribute("Books", bookservices.findAllBooks());
		req.setAttribute("mode","ViewBook");
		return "addbooks";
		
	}
	
	@RequestMapping("/deleteBook")
	public String deletebook(@RequestParam long id,HttpServletRequest req){
		bookservices.deleteBook(id);
		req.setAttribute("Books", bookservices.findAllBooks());
		req.setAttribute("mode", "ViewBook");
		return "addbooks";
		
		}
	@RequestMapping("/editBook")
	public String editbook(@RequestParam long id,HttpServletRequest req){
		
		req.setAttribute("Book", bookservices.findOneBook(id));
		req.setAttribute("mode", "EditBook");
		return "addbooks";
		
		}
	@GetMapping("/viewBook")
	public String viewbook(HttpServletRequest req) {
		req.setAttribute("Books", bookservices.findAllBooks());
		req.setAttribute("mode", "ViewBook");
		return "addbooks";
		
	}
	@GetMapping("/issueBookForm")
	public String issuebookform(HttpServletRequest req) {
		
		req.setAttribute("mode", "IssueBook");
		return "issuebookform";
		
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

	}
	@PostMapping("/issueBook")
	public ModelAndView issuebook(@ModelAttribute IssueBook issueBook , BindingResult result, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("issuebookform");
		Book book = null;
		try {
			book = bookservices.findOneBook(issueBook.getBid());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 
		int quantity = book.getQuantity();
		int issued = book.getIssued();
		
		if(quantity > issued) {
			
			issueServices.issueBook(issueBook);
			book.setIssued(issued + 1);
			bookservices.saveBook(book);
			mv.addObject("mode","BookIssued");
		}
		else {
			mv.addObject("mode","OutOfStock");
		}
		
	
		return mv;
		
	}
	@GetMapping("/viewIssueBook")
	public String viewIssueBook(HttpServletRequest req) {
		
		req.setAttribute("Issues", issueServices.findAllIssued());
		req.setAttribute("mode", "ViewIssuedBook");
		return "issuebookform";
		
	}

	@GetMapping("/returnBook")
	public String returnbook(@RequestParam("id") long id,@RequestParam("bid") long bid) {
		issueServices.returnIssuedBook(id,bid);
	
		
		return "returnbook";
		
	}
	
	
	@GetMapping("/addStudnetForm")
	public String studentform(HttpServletRequest req) {
		req.setAttribute("mode", "NewStudent");
		return "addstudentform";
		
	}
	@PostMapping("/saveStudent")
	public String savestudent(@ModelAttribute Student student,BindingResult res,HttpServletRequest req) {
		studServices.saveStudent(student);
		req.setAttribute("Studs", studServices.findAllStuds());
		req.setAttribute("mode", "ViewStudent");
		return "addstudentform";
		
	}
	@GetMapping("/viewStudents")
	public String viewstudent(HttpServletRequest req) {
		
		req.setAttribute("Studs", studServices.findAllStuds());
		req.setAttribute("mode", "ViewStudent");
		return "addstudentform";
		
	}
	@RequestMapping("/deleteStud")
	public String deletestud(@RequestParam("id") long id,HttpServletRequest req){
		studServices.deleteStud(id);
		req.setAttribute("Studs",studServices.findAllStuds());
		req.setAttribute("mode", "ViewStudent");
		return "addstudentform";
		
		}
	@RequestMapping("/editStud")
	public String editstud(@RequestParam("id") long id,HttpServletRequest req){
		req.setAttribute("Stud", studServices.findOneStud(id));
		req.setAttribute("mode", "EditStudent");
		return "addstudentform";
		
		}
	
}

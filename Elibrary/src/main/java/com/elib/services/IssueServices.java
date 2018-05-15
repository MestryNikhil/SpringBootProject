package com.elib.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.servlet.ModelAndView;

import com.elib.dao.IssueRepository;
import com.elib.models.Book;
import com.elib.models.IssueBook;

@Service
public class IssueServices {
	@Autowired
	private IssueRepository issueRepository;
	@Autowired
	private Bookservices bookservices; 


	public List<IssueBook> findAllIssued() {
		List<IssueBook> issuedBooks =new ArrayList<IssueBook>();
		for (IssueBook issueBook : issueRepository.findAll()) {
			issuedBooks.add(issueBook);
		}
		return issuedBooks;
	}

	public void returnIssuedBook(long id,long bid) {
		 
		issueRepository.delete(id);
			
		Book book =bookservices.findOneBook(bid);
		int issued = book.getIssued();
		book.setIssued(issued-1);
		bookservices.saveBook(book);
		
	
		
	}

	public void issueBook(IssueBook issueBook) {
		issueRepository.save(issueBook);
		
	}
}

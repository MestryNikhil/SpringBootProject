package com.elib.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elib.dao.BookRepository;
import com.elib.models.Book;

@Service
public class Bookservices {
	@Autowired
	private BookRepository bookRepository;

	public void saveBook(Book book) {
		
		bookRepository.save(book);
	}

	public List<Book> findAllBooks() {
		List<Book> books=new ArrayList<Book>();
		for (Book book : bookRepository.findAll()) {
			books.add(book);
		}
		return books;
	}

	public void deleteBook(long id) {

		bookRepository.delete(id);
		
	}

	public Book findOneBook(long id) {
		
		return bookRepository.findOne(id);
		
	}

	
	
	
}

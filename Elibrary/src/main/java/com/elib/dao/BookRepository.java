package com.elib.dao;

import org.springframework.data.repository.CrudRepository;

import com.elib.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	

}

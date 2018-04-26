package com.elib.dao;

import org.springframework.data.repository.CrudRepository;

import com.elib.models.Librarian;

public interface LibRepository extends CrudRepository<Librarian, Integer> {
	 Librarian findByName(String name);
}

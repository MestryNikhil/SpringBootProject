package com.elib.dao;

import org.springframework.data.repository.CrudRepository;

import com.elib.models.IssueBook;

public interface IssueRepository extends CrudRepository<IssueBook, Long> {

}

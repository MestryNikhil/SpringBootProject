package com.elib.dao;

import org.springframework.data.repository.CrudRepository;

import com.elib.models.Student;

public interface StudRepository extends CrudRepository<Student, Long> {

}

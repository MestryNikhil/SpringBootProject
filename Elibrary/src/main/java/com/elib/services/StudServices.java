package com.elib.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elib.dao.StudRepository;

import com.elib.models.Student;

@Service
public class StudServices {
	@Autowired
	private StudRepository studRepository;

	public void saveStudent(Student student) {
		
		studRepository.save(student);
	}

	public List<Student> findAllStuds() {
		List<Student> studs=new ArrayList<Student>();
		for (Student student : studRepository.findAll()) {
			studs.add(student);
			
		}
		return studs;
	}
	
	public void deleteStud(long id) {
		studRepository.delete(id);
		
		
	}

	public Student findOneStud(long id) {
		return studRepository.findOne(id);
		
	}


}

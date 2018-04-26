package com.elib.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.elib.dao.LibRepository;
import com.elib.dao.RoleRepository;
import com.elib.models.Librarian;
import com.elib.models.Role;

@Service
public class LibServices {
	@Autowired
	private LibRepository libRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RoleRepository roleRepository;

	public void saveLibrarian(Librarian lib) {
		Iterable<Role> iterable=roleRepository.findAll(); 
		Set<Role> roles = new HashSet<>();
		iterable.forEach(roles::add);
		lib.setPassword(bCryptPasswordEncoder.encode(lib.getPassword()));
		lib.setRoles(roles);
		try {
		libRepository.save(lib);
	}catch(Exception e) {
		e.printStackTrace();
		}
	}

	public List<Librarian> findAllLibs() {
		List<Librarian> libs =new ArrayList<Librarian>();
		for (Librarian librarian : libRepository.findAll()) {
			libs.add(librarian);
		}
		return libs;
	}

	public void deleteLibrarian(int id) {
		libRepository.delete(id);
		
	}

	public Librarian findOneLib(int id) {
		return libRepository.findOne(id);
	}
}

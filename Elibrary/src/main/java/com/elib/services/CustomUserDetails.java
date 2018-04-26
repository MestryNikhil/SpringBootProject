package com.elib.services;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elib.dao.LibRepository;
import com.elib.models.Librarian;
import com.elib.models.Role;

@Service
public class CustomUserDetails implements UserDetailsService {
	
	@Autowired
	private LibRepository libRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Librarian user=libRepository.findByName(name);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        for(Role role:user.getRoles()) {
        	grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
       return new User(user.getName(),user.getPassword(),grantedAuthorities);
	}

}
 
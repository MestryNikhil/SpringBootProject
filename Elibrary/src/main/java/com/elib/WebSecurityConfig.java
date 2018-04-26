package com.elib;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.elib.services.CustomUserDetails;
@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetails userDetailsService; 
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.antMatchers("/librarian/*").hasAnyRole("ADMIN","USER")
				.antMatchers("/admin/*").hasRole("ADMIN")
				 .antMatchers("/adminonly","/adminonly/*").hasRole("ADMIN")
                 .antMatchers("/libonly","/libonly/*").hasRole("USER")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.successHandler(successHandler)
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		
			
	}
	
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("nikhil").password("admin").roles("ADMIN","USER");
		auth.inMemoryAuthentication().withUser("anu").password("user").roles("USER");	
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
}

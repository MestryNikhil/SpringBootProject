package com.elib;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler  {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			for (GrantedAuthority grantedAuthority:authorities) {
				if(grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {	
					response.sendRedirect("/adminHome");
					return;
				}
				else if(grantedAuthority.getAuthority().equals("ROLE_USER")) {
					response.sendRedirect("/librarianHome");
					return;
				}
				else {
					throw new IllegalStateException();
				}
			}
		
	}

}

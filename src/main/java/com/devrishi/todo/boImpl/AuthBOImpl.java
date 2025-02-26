package com.devrishi.todo.boImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.devrishi.todo.bo.AuthBO;
import com.devrishi.todo.contract.LoginDTO;
import com.devrishi.todo.service.AuthService;
import com.devrishi.todo.exception.InvalidCredentialException;

@Component
public class AuthBOImpl implements AuthBO{
	
	@Autowired
	AuthService authService;
	
	public String login(LoginDTO userDetails) {
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String storedPassword = authService.getPassword(userDetails.getEmail());
		
		if(!passwordEncoder.matches(userDetails.getPassword(), storedPassword))
			throw new InvalidCredentialException("invalid credentials");
		
		return "access_token";
	}
}

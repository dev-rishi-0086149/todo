package com.devrishi.todo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devrishi.todo.exception.ResourceNotFoundException;
import com.devrishi.todo.repository.UserRepository;
import com.devrishi.todo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public String getPassword(String email) {
		System.out.println(email);
		String storedPassword = userRepository.getPasswordByEmail(email).orElseThrow(()-> new ResourceNotFoundException("Email not registered"));
		return storedPassword;
	}

}

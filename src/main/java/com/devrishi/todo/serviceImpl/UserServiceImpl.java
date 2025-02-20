package com.devrishi.todo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devrishi.todo.contract.UserDTO;
import com.devrishi.todo.entity.UserEntity;
import com.devrishi.todo.service.UserService;
import com.devrishi.todo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDTO getuserById(int userId) {
		
		UserDTO userData = userRepository.findByTxnId(userId); 
		
		return  userData;
	}
	
}

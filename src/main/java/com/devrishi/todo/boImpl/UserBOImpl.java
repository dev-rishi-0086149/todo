package com.devrishi.todo.boImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devrishi.todo.bo.UserBO;
import com.devrishi.todo.contract.UserDTO;
import com.devrishi.todo.service.UserService;


@Component
public class UserBOImpl implements UserBO{

	@Autowired
	UserService userService;
	
	@Override
	public UserDTO getUserById(int userId) {
		
		UserDTO userData = userService.getuserById(userId);
		return userData;
	}
	
	@Override
	public UserDTO postUserDetails(UserDTO userDetails) {
		UserDTO userData = userService.postUserDetails(userDetails);
		return userData;
	}

}

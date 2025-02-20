package com.devrishi.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devrishi.todo.contract.BaseResponseVO;
import com.devrishi.todo.contract.ResponseStatusVO;
import com.devrishi.todo.bo.UserBO;
import com.devrishi.todo.contract.UserDTO;
import com.devrishi.util.StatusUtil;

//Query parameter  @RequestParam(defaultValue = "Unknown") String name 
//path variable    @PathVariable int id

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserBO userBO;
	
	@GetMapping("/user/{id}")
	public BaseResponseVO getUser(@PathVariable int id) {
		BaseResponseVO response = new BaseResponseVO();
		ResponseStatusVO status ;
		try {
			UserDTO userdetails = userBO.getUserById(id);
			status = StatusUtil.getStatus("SUCCESS");
			response.setResponse(userdetails);
		}
		catch(Exception e) {
			status = StatusUtil.getStatus("FAILED TO GET USER DATA");
		}
		response.setStatus(status);
		
		return response;
	}
}

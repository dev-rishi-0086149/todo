package com.devrishi.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devrishi.todo.contract.BaseResponseVO;
import com.devrishi.todo.contract.ResponseStatusVO;
import com.devrishi.todo.bo.UserBO;
import com.devrishi.todo.contract.UserDTO;
import com.devrishi.todo.exception.ResourceNotFoundException;
import com.devrishi.todo.util.StatusUtil;

import jakarta.validation.Valid;

//Query parameter  @RequestParam(defaultValue = "Unknown") String name 
//path variable    @PathVariable int id

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserBO userBO;

	@GetMapping("/{id}")
	public ResponseEntity<BaseResponseVO> getUser(@PathVariable int id) {
		BaseResponseVO response = new BaseResponseVO();
		ResponseStatusVO status;
		UserDTO userdetails = userBO.getUserById(id);
		status = StatusUtil.getStatus("SUCCESS");
		response.setResponse(userdetails);
		response.setStatus(status);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/")
	public ResponseEntity<BaseResponseVO> postUser(@Valid @RequestBody UserDTO userdetails) {
		BaseResponseVO response = new BaseResponseVO();
		ResponseStatusVO status;
		try {
			UserDTO userDetails = userBO.postUserDetails(userdetails);
			status = StatusUtil.getStatus("SUCCESS");
			response.setResponse(userDetails);
			response.setStatus(status);
		} catch (Exception e) {
			status = StatusUtil.getStatus("FAILED TO POST USER DATA : " + e.getMessage());
			response.setStatus(status);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

//	@DeleteMapping("/{id}")
//	public ResponseEntity<BaseResponseVO> deleteUser(@PathVariable int id){
//		
//	}
//	

}

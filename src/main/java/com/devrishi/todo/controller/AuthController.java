package com.devrishi.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devrishi.todo.bo.AuthBO;
import com.devrishi.todo.contract.BaseResponseVO;
import com.devrishi.todo.contract.LoginDTO;
import com.devrishi.todo.contract.ResponseStatusVO;
import com.devrishi.todo.util.StatusUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthBO authBO;

	@PostMapping("/")
	public ResponseEntity<BaseResponseVO> login(@RequestBody LoginDTO loginDetails) {
		BaseResponseVO response = new BaseResponseVO();
		ResponseStatusVO status=StatusUtil.getStatus("SUCCESS");
		response.setStatus(status);
		authBO.login(loginDetails);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	}

}

package com.devrishi.todo.bo;

import com.devrishi.todo.contract.LoginDTO;

public interface AuthBO {
	String login(LoginDTO loginDetails);
}

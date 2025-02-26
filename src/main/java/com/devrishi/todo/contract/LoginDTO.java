package com.devrishi.todo.contract;


public class LoginDTO {
	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}

	private String email;
	
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

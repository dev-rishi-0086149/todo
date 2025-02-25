package com.devrishi.todo.contract;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {
	private int txnId;
	
	@NotNull(message = "Name cant be null")
	private String name;
	
	@Email(message ="Invalid email")
	@NotBlank(message= "Email cant be blank")
	private String email;
	
	@NotNull
	@Max(value=90,message="max allowed age 90")
	@Min(value=18,message="min allowed age 18")
	private int age;
	
	@NotNull
	@Size(min = 5, max = 15, message = "password must be between 5 and 15 characters")
	private String password ;
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public UserDTO(int txnId, String name, String email, int age) {
		//super();
		this.txnId = txnId;
		this.name = name;
		this.email = email;
		this.age = age;
	}
}

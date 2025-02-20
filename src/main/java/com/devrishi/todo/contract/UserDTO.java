package com.devrishi.todo.contract;

import lombok.Data;

@Data
public class UserDTO {
	private int txnId;
	private String name;
	private String email;
	private int age;
	public int getTxnId() {
		return txnId;
	}
	public void setTxnId(int txnId) {
		this.txnId = txnId;
	}
	public UserDTO(int txnId, String name, String email, int age) {
		super();
		this.txnId = txnId;
		this.name = name;
		this.email = email;
		this.age = age;
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
}

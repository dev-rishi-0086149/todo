package com.devrishi.todo.exception;

public class InvalidCredentialException extends RuntimeException{
	public InvalidCredentialException(String msg) {
		super(msg);
	}
}

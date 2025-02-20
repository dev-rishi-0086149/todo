package com.devrishi.todo.contract;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseStatusVO {
	private String message;
	private LocalDateTime time;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime localDateTime) {
		this.time = localDateTime;
	}
}

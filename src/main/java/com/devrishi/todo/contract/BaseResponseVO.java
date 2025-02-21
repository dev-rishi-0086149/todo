package com.devrishi.todo.contract;


public class BaseResponseVO {
	private ResponseStatusVO status;
	private Object response;
	public ResponseStatusVO getStatus() {
		return status;
	}
	public void setStatus(ResponseStatusVO status) {
		this.status = status;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
}

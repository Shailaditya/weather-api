package com.hackerrank.weather.model;

public class ApiResponse {
	public enum Status {
		SUCCESS,ERROR
	}
	private Status status;
	private String message;
	private Object data;
	
	public ApiResponse() {
	}
	
	public ApiResponse(Status status) {
		this.status = status;
	}
	
	public ApiResponse(Status status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public ApiResponse(Status status, Object data) {
		this.status = status;
		this.data = data;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}

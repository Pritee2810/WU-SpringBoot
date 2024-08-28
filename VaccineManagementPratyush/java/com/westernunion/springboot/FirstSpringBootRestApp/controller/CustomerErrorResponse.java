package com.westernunion.springboot.FirstSpringBootRestApp.controller;

public class CustomerErrorResponse {
	private int Status;
	private String Message;
	private long TimeStamp;
	
	public CustomerErrorResponse() {
		
	}
	public CustomerErrorResponse(int status, String message, long timeStamp) {
		super();
		Status = status;
		Message = message;
		TimeStamp = timeStamp;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public long getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		TimeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "CustomerErrorResponse [Status=" + Status + ", Message=" + Message + ", TimeStamp=" + TimeStamp + "]";
	}
	
	
}

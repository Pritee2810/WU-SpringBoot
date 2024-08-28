package com.westernunion.springboot.FirstSpringBootRestApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRESTExceptionHandler {
	//method to handle CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException cnfe){
		CustomerErrorResponse myResponse = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
				cnfe.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity(myResponse, HttpStatus.NOT_FOUND);
			
	}
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e){
		CustomerErrorResponse myResponse = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
				e.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity(myResponse, HttpStatus.BAD_REQUEST);
			
	}
}

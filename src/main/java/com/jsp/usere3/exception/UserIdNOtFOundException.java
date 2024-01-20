package com.jsp.usere3.exception;

import lombok.Getter;

@Getter
public class UserIdNOtFOundException extends RuntimeException {

	private String message;

	public UserIdNOtFOundException(String message) {
		super();
		this.message = message;
	}
	
	
	
}

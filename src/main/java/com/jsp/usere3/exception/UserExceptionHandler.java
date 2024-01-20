package com.jsp.usere3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.usere3.util.ResponseStructure;
@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> handleUserIdNotFound(UserIdNOtFOundException ex){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setMessage("Sorry User ID is Not found");
		structure.setHttpStatus(HttpStatus.NOT_FOUND.value());
		structure.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	} 
}

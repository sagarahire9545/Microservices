package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.payload.ApiRespone;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RsourceNotFoundException.class)
	public ResponseEntity<ApiRespone> handlerResourceNotFound(RsourceNotFoundException ex) {

		String message = ex.getMessage();
		ApiRespone response = ApiRespone.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiRespone>(response, HttpStatus.NOT_FOUND);

	}

}

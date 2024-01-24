package com.exception;

public class RsourceNotFoundException extends RuntimeException {

	public RsourceNotFoundException() {
		super("Resource not found on the server !!");
	}

	public RsourceNotFoundException(String msg) {
		super(msg);
	}
}

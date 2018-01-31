package com.hrsys.exception;

public class UserServiceException extends RuntimeException{
	public UserServiceException(String infor) {
		super(infor);
	}
}

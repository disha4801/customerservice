package com.dnb.customerservice.exceptions;


public class InvalidAccountIdException extends Exception {

	public InvalidAccountIdException(String msg) {

		super(msg);
	}

	@Override
	public String toString() {
		return super.toString() + super.getMessage();

	}

}
package com.dnb.customerservice.exceptions;

public class InvalidCustomerIdException extends Exception {
	
	public InvalidCustomerIdException (String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString() + super.getMessage();
	}

}

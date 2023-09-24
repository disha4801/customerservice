package com.dnb.customerservice.exceptions;

public class InvalidContactNumberException extends Exception {
	public InvalidContactNumberException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString() + super.getMessage();
	}

}

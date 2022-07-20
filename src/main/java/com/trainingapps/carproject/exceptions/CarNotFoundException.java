package com.trainingapps.carproject.exceptions;

public class CarNotFoundException extends RuntimeException {
	public CarNotFoundException(String msg) {
		super(msg);
	}
}

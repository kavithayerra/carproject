package com.trainingapps.carproject.exceptions;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	private static final Logger LOG=LoggerFactory.getLogger(CentralizedExceptionHandler.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CarNotFoundException.class)
	public String handleCarNotFound(CarNotFoundException e) {
		String msg=e.getMessage();
		LOG.info(msg,e);
		return msg;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class
    })
    public String handleInvalid(Exception e) {
        String msg = e.getMessage();
    	LOG.info(msg,e);
    	return msg;
    }

	
}

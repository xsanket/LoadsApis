package com.Liveasy.Exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Liveasy.Response.apiResponse;

@RestControllerAdvice
public class loadsException {
	
	@ExceptionHandler(ConfigDataResourceNotFoundException.class)
	public ResponseEntity<apiResponse> resourceNotFoundExceptionHandler(ConfigDataResourceNotFoundException exception) {
		String message = exception.getMessage();
		apiResponse apiRes = new apiResponse(message);
		return new ResponseEntity<apiResponse>(apiRes, HttpStatus.NOT_FOUND);
	}

}

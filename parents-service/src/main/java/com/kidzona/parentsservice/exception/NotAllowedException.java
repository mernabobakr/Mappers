package com.kidzona.parentsservice.exception;

import org.springframework.http.HttpStatus;

public class NotAllowedException extends ApiBaseException{

	public NotAllowedException(String message) {
		super(message);
	}

	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.NOT_ACCEPTABLE;
	}

}

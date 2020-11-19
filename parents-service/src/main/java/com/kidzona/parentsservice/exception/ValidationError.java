package com.kidzona.parentsservice.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ValidationError {
	public ValidationError() {

		this.timestamp = new Date();
		this.errors = new ArrayList<>();
	}

	private List<String> errors;

	public List<String> getErrors() {
		return errors;
	}

	public void addError(String error) {
		this.errors.add(error) ;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	private String url;
	// de 3shan a5ly eldate fe eljson format
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;
}

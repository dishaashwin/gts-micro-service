package com.assignment.chaukuriWorkExperience.models;

import org.springframework.http.HttpStatus;

public class WorkExperienceResponseBody {
	private String message;
	 private String success;
	 private Integer statusCode ;
	

	
	 public WorkExperienceResponseBody(String message, String success, Integer statusCode) {
			super();
			
			this.message = message;
			this.success = success;
			this.statusCode = statusCode;
		}

	

	

	

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	

	
   
	

}

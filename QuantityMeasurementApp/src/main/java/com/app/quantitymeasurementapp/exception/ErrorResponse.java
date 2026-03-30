package com.app.quantitymeasurementapp.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ErrorResponse {
	public LocalDateTime dateTime;
	public int status;
	public String error;
	public String message;
	public String path;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}

}
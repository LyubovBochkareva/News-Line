package ru.sibers.test.newsline.handler.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Lyubov Bochkareva
 * @since 31.07.20.
 */

public class ApiError {

	private String message;
	private HttpStatus status;

	public ApiError(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
	}

	public ApiError(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}

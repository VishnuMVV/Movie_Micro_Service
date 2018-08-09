package com.stackroute.movieapplication.exceptions;

public class MovieAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieAlreadyExistsException(String exception) {

		super(exception);

	}
}

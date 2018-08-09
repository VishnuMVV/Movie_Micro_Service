package com.stackroute.movieapplication.exceptions;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MovieNotFoundException(String exception) {

		super(exception);

	}
}

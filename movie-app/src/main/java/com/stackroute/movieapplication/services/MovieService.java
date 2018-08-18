package com.stackroute.movieapplication.services;

import java.util.List;

import com.stackroute.movieapplication.domain.Movie;

public interface MovieService {

	public Movie saveMovie(Movie movie);

	public List<Movie> getAllMovies();

	public String deleteMovie(String movieId);

	public Movie getMovieById(String movieId);

	public Movie updateMovie(Movie movie, String movieId);

}

package com.stackroute.movieapplication.services;

import java.util.List;

import com.stackroute.movieapplication.domain.Movie;

public interface MovieService {

	public Movie saveMovie(Movie movie);

	public List<Movie> getAllMovies();

	public int deleteMovie(int movieId);

	public Movie getMovieById(int movieId);

	public Movie updateMovie(Movie movie, int movieId);

}

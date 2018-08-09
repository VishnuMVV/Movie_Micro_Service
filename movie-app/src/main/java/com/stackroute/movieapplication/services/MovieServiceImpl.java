package com.stackroute.movieapplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.movieapplication.domain.Movie;
import com.stackroute.movieapplication.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapplication.exceptions.MovieNotFoundException;
import com.stackroute.movieapplication.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	private MovieRepository movieRepository;

	public MovieServiceImpl() {

	}

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {

		this.movieRepository = movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) {

		int movieId = movie.getMovieId();
		if (movieRepository.existsById(movieId)) {
			throw new MovieAlreadyExistsException("The movieId is already present in the database");
		} else {
			Movie movieObj = movieRepository.save(movie);
			return movieObj;
		}

	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movieList = (List<Movie>) movieRepository.findAll();
		return movieList;
	}

	@Override
	public int deleteMovie(int movieId) {

		movieRepository.deleteById(movieId);
		return movieId;
	}

	@Override
	public Movie updateMovie(Movie movie, int movieId) {

		Optional<Movie> movieObj = movieRepository.findById(movieId);
		if (!movieObj.isPresent())
			throw new MovieNotFoundException("The movieId is not present in the database");
		movie.setMovieId(movieId);

		return movieRepository.save(movie);
	}

	@Override
	public Movie getMovieById(int movieId) {

		Optional<Movie> movieObj = movieRepository.findById(movieId);
		if (!movieObj.isPresent())
			throw new MovieNotFoundException("The movieId is not present in the database");

		return movieObj.get();
	}

}

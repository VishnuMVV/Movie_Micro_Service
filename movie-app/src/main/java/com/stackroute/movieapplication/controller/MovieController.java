package com.stackroute.movieapplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieapplication.domain.Movie;
import com.stackroute.movieapplication.services.MovieService;

@RestController
@RequestMapping(value = "/api/v1")
public class MovieController {

	private MovieService movieService;

	public MovieController(MovieService movieService) {

		this.movieService = movieService;

	}

	@RequestMapping("/")
	public String display() {

		return "Hello";

	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {

		Movie movieObj = movieService.saveMovie(movie);
		return new ResponseEntity<Movie>(movieObj, HttpStatus.OK);

	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMovies() {

		List<Movie> list = movieService.getAllMovies();
		return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE, produces = { "application/json" })
	public ResponseEntity<String> deleteMoviefromDB(@PathVariable int id) {

		int movieId = movieService.deleteMovie(id);

		if (movieId == 0) {

			return new ResponseEntity<String>("deleted movieId" + movieId, HttpStatus.NOT_FOUND);

		} else {

			return new ResponseEntity<String>("deleted movieId" + movieId, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable int movieId) {

		Movie movieObj = movieService.updateMovie(movie, movieId);

		return new ResponseEntity<Movie>(movieObj, HttpStatus.OK);

	}

	@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Movie> getById(@PathVariable int movieId) {

		if (movieService.getMovieById(movieId) == null) {

			return new ResponseEntity<Movie>(movieService.getMovieById(movieId), HttpStatus.NOT_FOUND);

		} else {

			return new ResponseEntity<Movie>(movieService.getMovieById(movieId), HttpStatus.FOUND);
		}

	}

}

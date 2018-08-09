//package com.stackroute.movieapplication.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//
//import com.stackroute.movieapplication.domain.Movie;
//import com.stackroute.movieapplication.repository.MovieRepository;
//
//@Configuration
//public class BootStrapData implements ApplicationListener<ContextRefreshedEvent> {
//
//	private MovieRepository movieRepository;
//	private Movie movie;
//
//	@Autowired
//	public BootStrapData(MovieRepository movieRepository) {
//
//		this.movieRepository = movieRepository;
//
//	}
//
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		Movie movie = new Movie();
//		movie.setMovieId(1);
//		movie.setMovieTitle("abc");
//		movieRepository.save(movie);
//		Movie testMovie = Movie.builder().movieId(2).movieTitle("foo").build();
//
//		movieRepository.save(testMovie);
//	}
//
//}

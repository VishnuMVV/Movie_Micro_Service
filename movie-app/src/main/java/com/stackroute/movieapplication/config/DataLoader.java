package com.stackroute.movieapplication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.stackroute.movieapplication.domain.Movie;
import com.stackroute.movieapplication.repository.MovieRepository;

@Configuration
public class DataLoader implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

	@Autowired
	private MovieRepository movieRepository;

	public DataLoader(MovieRepository movieRepository) {

		this.movieRepository = movieRepository;

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside CommandLineRunner class");
		logger.info("Loading data...");

		movieRepository.save(new Movie("1", "First","100","completed",2020));
		movieRepository.save(new Movie("2", "Second","90","completed",2020));

	}
}

package com.stackroute.movieapplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.movieapplication.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}

package com.stardust.moviedb.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stardust.moviedb.model.Movie;

@Repository
public interface InterfaceMovie extends CrudRepository<Movie, Integer>{

}

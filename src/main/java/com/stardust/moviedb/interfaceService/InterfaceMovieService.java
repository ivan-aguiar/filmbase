package com.stardust.moviedb.interfaceService;

import java.util.List;
import java.util.Optional;

import com.stardust.moviedb.model.Movie;

//Métodos del CRUD
public interface InterfaceMovieService {
	public List<Movie>list();
	public Optional<Movie>listID(int id);
	public int save(Movie m);
	public void delete(int id);
}

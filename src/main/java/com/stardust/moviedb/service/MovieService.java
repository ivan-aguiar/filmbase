package com.stardust.moviedb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stardust.moviedb.interfaceService.InterfaceMovieService;
import com.stardust.moviedb.interfaces.InterfaceMovie;
import com.stardust.moviedb.model.Movie;

@Service
public class MovieService implements InterfaceMovieService{
	
	@Autowired
	private InterfaceMovie data;
	@Override
	public List<Movie> list() {
		return (List<Movie>)data.findAll();
	}

	@Override
	public Optional<Movie> listID(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Movie m) {
		int res=0;
		Movie movie = data.save(m);
		if(!movie.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}

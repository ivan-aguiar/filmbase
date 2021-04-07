package com.stardust.moviedb.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stardust.moviedb.interfaceService.InterfaceMovieService;
import com.stardust.moviedb.model.Movie;

@Controller
@RequestMapping
public class MainController {

	@Autowired
	private InterfaceMovieService service;

	@GetMapping("/")
	public String list(Model model) {
		List<Movie> movie = service.list();
		model.addAttribute("movies", movie);
		return "index";
	}

	@GetMapping("/addMovie")
	public String add(Model model) {
		model.addAttribute("movie", new Movie());
		return "form";
	}

	@PostMapping("/save")
	public String save(@Valid Movie m, Model model) {
		service.save(m);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<Movie> movie = service.listID(id);
		model.addAttribute("movie", movie);
		return "form";
	}

	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/";
	}
}

package com.demo.movie.service;

import com.demo.movie.Model.MovieResponse;
import com.demo.movie.Model.Movies;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public abstract interface MovieService {
    public MovieResponse createMovie(@RequestBody Movies movies);
    public List<Movies> getAllMovies();
    public String deleteMovies();
    public MovieResponse deleteMoviesBYId(@PathVariable String id);
    public List<Movies> getMoviesByName(@PathVariable String movieName);
    public List<Movies> getAllMovieRecords();
}

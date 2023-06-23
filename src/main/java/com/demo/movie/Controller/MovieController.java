package com.demo.movie.Controller;

import com.demo.movie.Model.MovieResponse;
import com.demo.movie.Model.Movies;
import com.demo.movie.Repository.MovieRepository;
import com.demo.movie.Repository.ShowRepository;
import com.demo.movie.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController extends MovieServiceImpl{

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MovieServiceImpl movieServiceImpl;

    @PostMapping(value = "/createMovie")
    public MovieResponse createMovies(@RequestBody Movies movies)
    {
        return movieServiceImpl.createMovie(movies);
    }

    @GetMapping(value = "/getAllMovies")
    public List<Movies> getAllMovie()
    {
        return movieServiceImpl.getAllMovies();
    }

    @GetMapping(value = "/getAllMovieRecords")
    public List<Movies> getAllMoviesRecords()
    {
        return movieServiceImpl.getAllMovieRecords();
    }

    @DeleteMapping(value = "/deleteMovies")
    public String deleteMovie()
    {
        return movieServiceImpl.deleteMovies();
    }
    @PostMapping(value = "/deleteMoviesById/{id}")
    public MovieResponse deleteMovieById(@PathVariable String id){
        return movieServiceImpl.deleteMoviesBYId(id);
    }

    @GetMapping(value = "/getMoviesByName/{movieName}")
    public  List<Movies> getMovieByName(@PathVariable String movieName)
    {
        return movieServiceImpl.getMoviesByName(movieName);
    }
//    @GetMapping(value = "/findMovieByName")
//    public List<Movies> findMovieByName(@PathVariable String movieName)
//    {
//        Movies mv=new Movies();
//        Query query= new Query(Criteria.where("movieName").is(movieName));
//        return mongoTemplate.find(query,Movies.class);
//    }
}

package com.demo.movie.service;

import com.demo.movie.Model.MovieResponse;
import com.demo.movie.Model.Movies;
import com.demo.movie.Model.Shows;
import com.demo.movie.Model.Users;
import com.demo.movie.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public MovieResponse createMovie(Movies movies) {

        String id=movies.getShow().getShowId();
//        if (movies.getShow().isSoftDelete() == false) {
//            return new MovieResponse("No Show Slot Available Please Create desired Show", "");
//        }
//        else {
        List<Shows> show;
        Query query = new Query();
        query.addCriteria(Criteria.where("showId").is(id));
        show = mongoTemplate.find(query, Shows.class);
        for(int i=0 ; i<show.size() ; i++) {
            System.out.println(""+show.get(i).isSoftDelete());
            boolean ShowValue = show.get(i).isSoftDelete();
            System.out.println("ShowValue"+ShowValue);
            if (show.get(i).isSoftDelete() == false)
            {
                return new MovieResponse("No Show Slot Available Please Create desired Show", "");
            }
            else
            {
              //Setting Default Value of Movie's softDelete = true; //
                boolean value=true;
                // Value Of movies.getShow().isSoftDelete was coming False Though in database its true//
                movies.getShow().setSoftDelete(ShowValue);
                Movies createdMovie = new Movies();
                createdMovie.setMovieName(movies.getMovieName());
                createdMovie.setGenere(movies.getGenere());
                createdMovie.setLanguage(movies.getLanguage());
                createdMovie.setPrice(movies.getPrice());
                createdMovie.setSoftDelete(value);
                createdMovie.setShow(movies.getShow());
                Movies mv = movieRepository.save(createdMovie);
                return new MovieResponse("Movie Succesfully Created", "" + createdMovie.getMovieName());
            }
        }
        return null;
    }

    @Override
    public List<Movies> getAllMovies() {
        List<Movies> movie;
        List<Movies> ReturnList = new ArrayList<>();
        movie = movieRepository.findAll();
        for(int i=0; i<movie.size(); i++)
        {
            if(movie.get(i).isSoftDelete() == true)
            {
                if(movie.get(i).getShow().isSoftDelete()==true)
                {
                    ReturnList.add(movie.get(i));
                }
            }
        }
        return ReturnList;
    }

    @Override
    public String deleteMovies() {
        movieRepository.deleteAll();
        return "Movies Deleted";
    }

    @Override
    public MovieResponse deleteMoviesBYId(String id) {
        List<Movies> movie;
        boolean value;
        boolean value1;
        Query query = new Query();
        query.addCriteria(Criteria.where("movieid").is(id));
        movie = mongoTemplate.find(query,Movies.class);
        for (int i=0 ; i<movie.size() ; i++)
        {
            if(movie.get(i).isSoftDelete()== true)
            {
                value = false;
                movie.get(i).setSoftDelete(value);
                System.out.println("" + movie.get(i).getShow().isSoftDelete());
                movie.get(i).getShow().setSoftDelete(false);
                System.out.println("" + movie.get(i).getShow().isSoftDelete());
                movieRepository.save(movie.get(i));

                return new MovieResponse("Movie Deleted Succesfully","" +movie.get(i).getMovieName());
            }
            else
            {
                return new MovieResponse("No Such Movie Exists"," " + movie.get(i).getMovieName());

            }
        }
        return null;
    }


    @Override
    public  List<Movies> getMoviesByName(String movieName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("movieName").is(movieName));
        List<Movies> movie = mongoTemplate.find(query, Movies.class);
        return movie;
    }

    @Override
    public List<Movies> getAllMovieRecords()
    {
        return movieRepository.findAll();
    }
}

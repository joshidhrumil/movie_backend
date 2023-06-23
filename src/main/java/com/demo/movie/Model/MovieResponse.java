package com.demo.movie.Model;


public class MovieResponse {

    public String messgae;
    public String moviename;

    public MovieResponse() {
    }

    public MovieResponse(String messgae, String moviename) {
        this.messgae = messgae;
        this.moviename = moviename;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }
}

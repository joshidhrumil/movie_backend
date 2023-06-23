package com.demo.movie.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movies {

    @Id
    private String movieid;
    private String movieName;
    private String genere;
    private String[] language;
    private float price;
    @DBRef
    private Shows show;
    private boolean softDelete;

    //    private Language language;
    //    private MovieType movieType;


    public Movies() {
    }

    @Autowired
    public Movies(String movieid, String movieName, String genere, Shows show, float price,boolean softDelete, String[] language) {
        this.movieid = movieid;
        this.movieName = movieName;
        this.genere = genere;
        this.language = language;
        this.price=price;
        this.softDelete = softDelete;
        this.show= show;
    }
    @Autowired
    public Movies( Shows show)
    {
        this.show=show;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Shows getShow() {
        return show;
    }

    public void setShow(Shows show) {
        this.show = show;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }


}

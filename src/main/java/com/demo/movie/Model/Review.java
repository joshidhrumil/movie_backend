package com.demo.movie.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Review {

    @Id
    private String review_id;

    @DBRef
    private Bookings bookings;

    private String review;

    public Review() {
    }

    @Autowired
    public Review(Bookings bookings) {
        this.bookings = bookings;
    }

    @Autowired
    public Review(String review_id,Bookings bookings, String review) {
        this.review_id= review_id;
        this.bookings = bookings;
        this.review = review;
    }

    public String getReview_id() {
        return review_id;
    }

    public void setReview_id(String review_id) {
        this.review_id = review_id;
    }

    public Bookings getBookings() {
        return bookings;
    }

    public void setBookings(Bookings bookings) {
        this.bookings = bookings;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}

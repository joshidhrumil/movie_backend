package com.demo.movie.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bookings {

    @Id
    private String bookingId;

    @DBRef
    private Users user;

    @DBRef
    private Movies movie;

    private int quantity;

    private float total;

    private boolean softDelete;

    public Bookings() {
    }

    @Autowired
    public Bookings(String bookingId, Users user, Movies movie,int quantity,float total,boolean softDelete) {
        this.bookingId = bookingId;
        this.user = user;
        this.movie = movie;
        this.quantity =quantity;
        this.total = total;
        this.softDelete =softDelete;

    }

    @Autowired
    public Bookings(int quantity) {
        this.quantity = quantity;
    }

    @Autowired
    public Bookings(float total) {
        this.total = total;
    }

    @Autowired
    public Bookings( Users user) {
        this.user = user;
    }

    @Autowired
    public Bookings(Movies movie) {

        this.movie = movie;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }
}

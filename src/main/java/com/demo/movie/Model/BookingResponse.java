package com.demo.movie.Model;

public class BookingResponse {
    String MovieName;
    String BookingId;

    public BookingResponse(String BookingId, String MovieName) {
        this.MovieName = MovieName;
        this.BookingId = BookingId;
    }

    public BookingResponse() {
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String bookingId) {
        BookingId = bookingId;
    }
}

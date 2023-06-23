package com.demo.movie.Model;

public class ReviewResponse {
    public String Message;
    public String BookingID;
    public String PublishedReview;

    public ReviewResponse(String message, String bookingID, String publishedReview) {
        Message = message;
        BookingID = bookingID;
        PublishedReview = publishedReview;
    }

    public ReviewResponse(String message) {
        Message = message;
    }

    public ReviewResponse() {
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String bookingID) {
        BookingID = bookingID;
    }

    public String getPublishedReview() {
        return PublishedReview;
    }

    public void setPublishedReview(String publishedReview) {
        PublishedReview = publishedReview;
    }
}

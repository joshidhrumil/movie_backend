package com.demo.movie.service;

import com.demo.movie.Model.Review;
import com.demo.movie.Model.ReviewResponse;
import com.demo.movie.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public ReviewResponse createReview(Review review) {
        Review rev= new Review();
        rev.setBookings(review.getBookings());
        rev.setReview(review.getReview());
        Review getReview=reviewRepository.save(rev);
        return new ReviewResponse("Review Succesfully Saved",""+rev.getBookings().getBookingId(),""+rev.getReview());
    }

    @Override
    public Optional<Review> getReviewByID(String id) {
        Optional<Review> getReview= reviewRepository.findById(id);
        return getReview;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public ReviewResponse deleteAllReviews() {

        reviewRepository.deleteAll();
        return new ReviewResponse("All Reviews Deleted Succesfully");
    }
}

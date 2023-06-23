package com.demo.movie.service;

import com.demo.movie.Model.Review;
import com.demo.movie.Model.ReviewResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public abstract interface ReviewService  {
    public ReviewResponse createReview(@RequestBody Review review);
    public Optional<Review> getReviewByID(@PathVariable String id);
    public List<Review> getAllReviews();
    public ReviewResponse deleteAllReviews();
}

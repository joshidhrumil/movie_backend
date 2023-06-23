package com.demo.movie.Controller;

import com.demo.movie.Model.Review;
import com.demo.movie.Model.ReviewResponse;
import com.demo.movie.Repository.ReviewRepository;
import com.demo.movie.service.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/review")
public class ReviewController extends ReviewServiceImpl {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReviewServiceImpl reviewServiceImpl;

    @PostMapping(value = "/createReview")
    public ReviewResponse createReviews(@RequestBody Review review)
    {
       return reviewServiceImpl.createReview(review);
    }

    @GetMapping(value = "/getReviewByID/{id}")
    public Optional<Review> getReviewsByID(@PathVariable String id)
    {
        return reviewServiceImpl.getReviewByID(id);
    }

    @GetMapping(value = "/getAllReviews")
    public List<Review> getAllReview()
    {
        return reviewServiceImpl.getAllReviews();
    }

    @DeleteMapping(value = "/deleteAllReviews")
    public ReviewResponse deleteReviews()
    {
        return reviewServiceImpl.deleteAllReviews();
    }

}

package com.bd.movie.api.MovieAPI.Controller;

import com.bd.movie.api.MovieAPI.Model.Review;
import com.bd.movie.api.MovieAPI.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestParam Map<String, String> payload) {

        return new ResponseEntity<Review>(reviewService.createReview(payload.get("reviewBody"),
                payload.get("imdbId")), HttpStatus.OK);
    }



}

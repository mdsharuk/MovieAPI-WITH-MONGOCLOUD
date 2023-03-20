package com.bd.movie.api.MovieAPI.Service;

import com.bd.movie.api.MovieAPI.Model.Movie;
import com.bd.movie.api.MovieAPI.Model.Review;
import com.bd.movie.api.MovieAPI.Repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    @Autowired
    private MongoTemplate template;


    public Review createReview(String reviewBody, String imdbId) {
           Review  review=reviewRepo.insert(new Review(reviewBody));

        template.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }

}

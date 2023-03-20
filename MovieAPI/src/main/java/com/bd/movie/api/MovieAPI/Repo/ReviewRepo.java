package com.bd.movie.api.MovieAPI.Repo;

import com.bd.movie.api.MovieAPI.Model.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends MongoRepository<Review, ObjectId> {
}

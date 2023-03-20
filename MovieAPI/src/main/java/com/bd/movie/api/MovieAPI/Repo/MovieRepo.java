package com.bd.movie.api.MovieAPI.Repo;

import com.bd.movie.api.MovieAPI.Model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepo extends MongoRepository<Movie, ObjectId> {

}

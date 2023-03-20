package com.bd.movie.api.MovieAPI.Repo;

import com.bd.movie.api.MovieAPI.Model.Movie;

import java.util.List;
import java.util.Optional;

public interface SerchRepo {
    List<Movie> findByimdbId(String imdbId);
}

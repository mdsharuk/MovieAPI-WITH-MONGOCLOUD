package com.bd.movie.api.MovieAPI.Service;


import com.bd.movie.api.MovieAPI.Model.Movie;
import com.bd.movie.api.MovieAPI.Repo.MovieRepo;
import com.bd.movie.api.MovieAPI.Repo.SerchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepo repo;
    @Autowired
    SerchRepo serchRepo;

    public List<Movie>getByMovie(){
        return repo.findAll();
    }

    public List<Movie>getBYimdb(String imdbId){
        return serchRepo.findByimdbId(imdbId);
    }
}

package com.bd.movie.api.MovieAPI.Controller;

import com.bd.movie.api.MovieAPI.Model.Movie;
import com.bd.movie.api.MovieAPI.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;


    @GetMapping("api/v1/movies")
    private List<Movie>getMovies(){
       return movieService.getByMovie();
    }


    @GetMapping("/{imdbId}")
    private List<Movie>getbyID(@PathVariable String imdbId){
       return movieService.getBYimdb(imdbId);
    }
}

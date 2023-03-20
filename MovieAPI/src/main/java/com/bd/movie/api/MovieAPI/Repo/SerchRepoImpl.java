package com.bd.movie.api.MovieAPI.Repo;


import com.bd.movie.api.MovieAPI.Model.Movie;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SerchRepoImpl implements  SerchRepo{
    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;
    @Override
    public List<Movie> findByimdbId(String imdbId) {
        final List<Movie> movie=new ArrayList<>();
        MongoDatabase database = client.getDatabase("Cluster1");
        MongoCollection<Document> collection = database.getCollection("Movie");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", imdbId)
                                .append("path", Arrays.asList("imdbId", "id", "title", "releaseData", "genres", "poster"))))));
                result.forEach(doc->movie.add(converter.read(Movie.class,doc)));
        return movie;
    }
}

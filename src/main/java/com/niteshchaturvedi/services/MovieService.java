package com.niteshchaturvedi.services;

import com.niteshchaturvedi.exceptions.NotFoundException;
import com.niteshchaturvedi.model.Movie;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {

    private final Map<String,Movie> movies;

    public MovieService() {
        movies = new HashMap<>();
    }
    public Movie getMovie(@NonNull final String movieId) {
        if (movies.containsKey(movieId)) {
            throw new NotFoundException();
        }
        return movies.get(movieId);
    }

    public Movie createMovie(@NonNull final String movieName) {
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId, movieName);
        movies.put(movieId, movie);
        return movie;
    }
}

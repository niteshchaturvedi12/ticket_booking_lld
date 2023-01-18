package com.niteshchaturvedi.api;

import com.niteshchaturvedi.model.Movie;
import com.niteshchaturvedi.services.MovieService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    public String createMovie(@NonNull final String movieName) {
        return movieService.createMovie(movieName).getId();
    }
}

package com.niteshchaturvedi.services;

import com.niteshchaturvedi.model.Movie;
import com.niteshchaturvedi.model.Screen;
import com.niteshchaturvedi.model.Show;
import lombok.NonNull;

import java.time.ZonedDateTime;

public class ShowService {
    public Show createShow(@NonNull final Movie movie, @NonNull final Screen screen, @NonNull final ZonedDateTime startTime,
                           @NonNull final Integer durationInSeconds) {
        return null;
    }

    public Show getShow(@NonNull final String showId) {
        return null;
    }
}

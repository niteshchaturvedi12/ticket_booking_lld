package com.niteshchaturvedi.api;

import com.niteshchaturvedi.model.Movie;
import com.niteshchaturvedi.model.Screen;
import com.niteshchaturvedi.model.Seat;
import com.niteshchaturvedi.model.Show;
import com.niteshchaturvedi.services.MovieService;
import com.niteshchaturvedi.services.SeatAvailabilityService;
import com.niteshchaturvedi.services.ShowService;
import com.niteshchaturvedi.services.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ShowController {
    private final SeatAvailabilityService seatAvailabilityService;
    private final ShowService showService;
    private final TheatreService theatreService;
    private final MovieService movieService;

    public String createShow(@NonNull final String movieId, @NonNull final String screenId,
                              @NonNull final ZonedDateTime startTime, @NonNull final Integer durationInSeconds) {
        final Screen screen = theatreService.getScreen(screenId);
        final Movie movie = movieService.getMovie(movieId);
        return showService.createShow(movie, screen, startTime, durationInSeconds).getId();
    }

    public List<String> getAvaialbleSeats(@NonNull final String showId) {
        Show show = showService.getShow(showId);
        final List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
    }
}

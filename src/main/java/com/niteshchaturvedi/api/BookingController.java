package com.niteshchaturvedi.api;

import com.niteshchaturvedi.model.Seat;
import com.niteshchaturvedi.model.Show;
import com.niteshchaturvedi.services.BookingService;
import com.niteshchaturvedi.services.ShowService;
import com.niteshchaturvedi.services.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookingController {
    private final TheatreService theatreService;
    private final ShowService showService;
    private final BookingService bookingService;

    public String createBooking(@NonNull final String userId, @NonNull final String showId,
                                @NonNull final List<String> seatIds) {
        final Show show = showService.getShow(showId);
        final List<Seat> seats = seatIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId, show, seats).getId();
    }
}

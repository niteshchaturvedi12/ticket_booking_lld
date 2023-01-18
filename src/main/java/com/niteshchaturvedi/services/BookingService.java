package com.niteshchaturvedi.services;

import com.niteshchaturvedi.exceptions.SeatPermanentlyUnavailableException;
import com.niteshchaturvedi.model.Booking;
import com.niteshchaturvedi.model.Seat;
import com.niteshchaturvedi.model.Show;
import com.niteshchaturvedi.providers.SeatLockProvider;
import lombok.NonNull;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {

    private final Map<String, Booking> showBookings;
    private final SeatLockProvider seatLockProvider;

    public BookingService(SeatLockProvider seatLockProvider) {
        this.seatLockProvider = seatLockProvider;
        this.showBookings = new HashMap<>();
    }
    public List<Seat> getBookedSeats(Show show) {
        return getAllBookings(show).stream().filter(Booking::isConfirmed).map(Booking::getSeatsBooked)
                .flatMap(Collection::stream).collect(Collectors.toList());
    }

    public List<Booking> getAllBookings(@NonNull final Show show) {
        List<Booking> bookings = new ArrayList<>();
        for (Booking booking : showBookings.values()) {
            if (booking.getShow().equals(show)) {
                bookings.add(booking);
            }
        }
        return bookings;
    }

    public Booking createBooking(@NonNull final String userId, @NonNull final Show show, @NonNull final List<Seat> seats) {
        if (isAnySeatAlreadyBooked(show, seats)) {
            throw new SeatPermanentlyUnavailableException();
        }
        return null;
    }

    private Boolean isAnySeatAlreadyBooked(@NonNull final Show show, @NonNull final List<Seat> seats) {
        final List<Seat> bookedSeats = getBookedSeats(show);
        for (Seat seat : seats) {
            if (bookedSeats.contains(seat)) {
                return true;
            }
        }
        return false;
    }
}

package com.niteshchaturvedi.model;

import com.niteshchaturvedi.exceptions.InvalidStatusException;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
@Getter
public class Booking {
    private final String id;
    private final Show show;
    private final String userName;
    private final List<Seat> seatsBooked;
    private BookingStatus bookingStatus;

    public Booking(@NonNull final String id, @NonNull final String userName,@NonNull final Show show,
                   @NonNull final List<Seat> seatsBooked) {
        this.id = id;
        this.userName =userName;
        this.show = show;
        this.seatsBooked = seatsBooked;
        this.bookingStatus = BookingStatus.Created;

    }

    public Boolean isConfirmed() {
        return BookingStatus.Created == bookingStatus;
    }

    public void confirmBooking() {
        if (BookingStatus.Created != bookingStatus) {
            throw new InvalidStatusException();
        }
        this.bookingStatus = BookingStatus.Confirmed;
    }

    public void expireBooking() {
        if (BookingStatus.Created != bookingStatus) {
            throw new InvalidStatusException();
        }
        this.bookingStatus = BookingStatus.Expired;
    }
}

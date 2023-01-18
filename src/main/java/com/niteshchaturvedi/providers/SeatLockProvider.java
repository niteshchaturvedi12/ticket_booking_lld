package com.niteshchaturvedi.providers;

import com.niteshchaturvedi.model.Seat;
import com.niteshchaturvedi.model.Show;

import java.util.List;

public interface SeatLockProvider {

    void lockSeats(Show show, List<Seat> seats, String userName);
    void unlockSeats(Show show, List<Seat> seats, String userName);
    Boolean validateLocks(Show show, List<Seat> seats, String userName);
    List<Seat> getLockedSeats(Show show);
}

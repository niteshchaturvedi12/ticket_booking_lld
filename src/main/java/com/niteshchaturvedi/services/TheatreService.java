package com.niteshchaturvedi.services;

import com.niteshchaturvedi.exceptions.NotFoundException;
import com.niteshchaturvedi.model.Screen;
import com.niteshchaturvedi.model.Seat;
import com.niteshchaturvedi.model.Theatre;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TheatreService {

    private final Map<String, Theatre> theaters;
    private final Map<String, Screen> screens;
    private final Map<String, Seat> seats;

    public TheatreService() {
        this.theaters = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();
    }
    public Theatre createTheatre(@NonNull final String theatreName) {
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, theatreName);
        theaters.put(theatreId, theatre);
        return theatre;
    }

    public String createScreenInTheatre(@NonNull final String screenName, @NonNull final Theatre theatre) {
        Screen screen = createScreen(screenName, theatre);
        theatre.addScreen(screen);
        return screen.getId();
    }

    private Screen createScreen(@NonNull final String screenName, Theatre theatre) {
        String screenId = UUID.randomUUID().toString();
        Screen screen = new Screen(screenId, screenName, theatre);
        screens.put(screenId, screen);
        return screen;
    }

    public Seat createSeatInScreen(@NonNull final Integer rowNo, @NonNull final Integer seatNo,
                                     @NonNull final Screen screen) {
        Seat seat = createSeat(rowNo, seatNo, screen);
        screen.addSeat(seat);
        return seat;
    }

    public Seat createSeat(@NonNull final Integer rowNo, @NonNull final Integer seatNo, @NonNull final Screen screen) {
        String seatId = UUID.randomUUID().toString();
        Seat seat = new Seat(seatId, rowNo, seatNo);
        seats.put(seatId, seat);
        return seat;
    }
    public Theatre getTheatre(@NonNull final String theatreId) {
        if (!theaters.containsKey(theatreId)) {
            throw new NotFoundException();
        }
        return theaters.get(theatreId);
    }

    public Screen getScreen(@NonNull final String screenId) {
        if (!screens.containsKey(screenId)) {
            throw new NotFoundException();
        }
        return screens.get(screenId);
    }

    public Seat getSeat(@NonNull final String seatId) {
        if (!seats.containsKey(seatId)) {
            throw new NotFoundException();
        }
        return seats.get(seatId);
    }
}

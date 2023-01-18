package com.niteshchaturvedi.api;

import com.niteshchaturvedi.model.Screen;
import com.niteshchaturvedi.model.Theatre;
import com.niteshchaturvedi.services.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class TheatreController {
    private final TheatreService theatreService;

    public String createTheatre(@NonNull final String theatreName) {
        return theatreService.createTheatre(theatreName).getId();
    }

    public String createScreenInTheatre(@NonNull final String screenName, @NonNull final String theatreId) {
        Theatre theatre = theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName, theatre);
    }
    public String createSeatInScreen(@NonNull final Integer rowNo, @NonNull final Integer seatNo,
                                     @NonNull final String screenId) {
        Screen screen = theatreService.getScreen(screenId);
        return theatreService.createSeat(rowNo, seatNo, screen).getId();
    }
}

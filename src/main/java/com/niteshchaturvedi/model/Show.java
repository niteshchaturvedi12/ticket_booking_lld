package com.niteshchaturvedi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Show {
    private String id;
    private Screen screen;
    private Movie movie;
    private LocalDateTime startTime;
    private Long durationInSeconds;
}

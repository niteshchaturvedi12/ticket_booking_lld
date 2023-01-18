package com.niteshchaturvedi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class SeatLock {
    private Seat seat;
    private Show show;
    private Long timeoutInSeconds;
    private ZonedDateTime lockTime;
    private String lockedBy;

    public Boolean isLockExpired() {
        final Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSeconds);
        final Instant currentInstant = ZonedDateTime.now().toInstant();
        return lockInstant.isBefore(currentInstant);
    }

}

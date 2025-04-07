package com.thecollinsbyte.booking;

import com.thecollinsbyte.guest.Guest;
import com.thecollinsbyte.room.Room;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Booking {

    private static final Logger LOG = LoggerFactory.getLogger(Booking.class);

    private final Guest guest;
    private final Room room;

    public Booking(Guest guest, Room room) {
        this.guest = guest;
        this.room = room;
        bookRoom();
    }

    private void bookRoom() {
        if (room.isAvailable()) {
            room.bookRoom();
            LOG.info("Booking confirmed for {} in room {}", guest.getGuestDetails(), room);
        } else {
            LOG.info("Sorry, room is already booked.");
        }
    }

    public String getBookingDetails() {
        return "Booking confirmed for " + guest.getGuestDetails() + " in " + room;
    }
}

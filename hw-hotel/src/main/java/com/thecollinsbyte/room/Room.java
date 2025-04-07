package com.thecollinsbyte.room;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Room {

    private static final Logger LOG = LoggerFactory.getLogger(Room.class);

    public int roomNumber;
    public RoomType roomType;
    public double price;
    public boolean isAvailable;

    public Room(int roomNumber, RoomType roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String bookRoom() {
        if(isAvailable) {
            isAvailable = false;
            return "Room Number " + roomNumber + " booked successfully.";
        } else {
            return "Room Number " + roomNumber + " is already booked.";
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType=" + roomType +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}

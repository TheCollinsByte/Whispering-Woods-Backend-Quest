package com.thecollinsbyte.room;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Hotel {

    private static final Logger LOG = LoggerFactory.getLogger(Hotel.class);

    private String name;
    private String location;
    private List<Room> rooms;

    public Hotel(String name, String location, List<Room> rooms) {
        this.name = name;
        this.location = location;
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
            "name='" + name + '\'' +
            ", location='" + location + '\'' +
            ", rooms=" + rooms +
        '}';
    }
}

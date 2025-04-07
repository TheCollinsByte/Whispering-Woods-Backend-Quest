package com.thecollinsbyte.guest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Abstract Guest class
public abstract class Guest {

    private static final Logger LOG = LoggerFactory.getLogger(Guest.class);

    public String name;

    public Guest(String name) {
        this.name = name;
    }

    public abstract String getGuestDetails();
}

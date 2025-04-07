package com.thecollinsbyte.guest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Individual Guest (Person)
public class IndividualGuest extends Guest{

    private static final Logger LOG = LoggerFactory.getLogger(IndividualGuest.class);

    private final String idNumber;

    public IndividualGuest(String name, String idNumber) {
        super(name);
        this.idNumber = idNumber;
    }

    @Override
    public String getGuestDetails() {
        return "Individual: " + name + " (ID: " + idNumber + ")";
    }
}

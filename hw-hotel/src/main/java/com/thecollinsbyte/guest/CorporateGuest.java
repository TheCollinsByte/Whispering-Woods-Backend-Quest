package com.thecollinsbyte.guest;

import com.thecollinsbyte.booking.Booking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Corporate Guest (Company)
public class CorporateGuest extends Guest{

    private static final Logger LOG = LoggerFactory.getLogger(CorporateGuest.class);

    private String companyName;
    private final String contactPerson;

    public CorporateGuest(String companyName, String contactPerson) {
        super(companyName);
        this.contactPerson = contactPerson;
    }

    @Override
    public String getGuestDetails() {
        return "Corporate: " + name + " (Contact: " + contactPerson + ")";
    }
}

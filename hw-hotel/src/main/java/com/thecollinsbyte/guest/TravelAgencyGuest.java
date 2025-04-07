package com.thecollinsbyte.guest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

// Travel Agency Guest (Travel Agency)
public class TravelAgencyGuest extends Guest{

    private static final Logger LOG = LoggerFactory.getLogger(TravelAgencyGuest.class);

    private final String agencyName;
    private final List<Guest> clients;

    public TravelAgencyGuest(String agencyName) {
        super(agencyName);
        this.agencyName = agencyName;
        this.clients = new ArrayList<>();
    }

    public void addClient(Guest client) {
        clients.add(client);
    }

    @Override
    public String getGuestDetails() {
        StringBuilder details = new StringBuilder("Travel Agency: " + name + "\nClients:");
        for (Guest client : clients) {
            details.append("\n  - ").append(client.getGuestDetails());
        }
        return details.toString();
    }
}

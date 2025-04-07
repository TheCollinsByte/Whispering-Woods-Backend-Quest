package com.thecollinsbyte.guest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

// Group Booking Guest (Group of people)
public class GroupBookingGuest extends Guest{

    private static final Logger LOG = LoggerFactory.getLogger(GroupBookingGuest.class);

    private final List<Guest> groupMembers;

    public GroupBookingGuest(String groupName) {
        super(groupName);
        this.groupMembers = new ArrayList<>();
    }

    public void addMember(Guest member) {
        groupMembers.add(member);
    }

    @Override
    public String getGuestDetails() {
        StringBuilder details = new StringBuilder("Group: " + name + "\nMembers:");
        for (Guest member : groupMembers) {
            details.append("\n  - ").append(member.getGuestDetails());
        }
        return details.toString();
    }
}

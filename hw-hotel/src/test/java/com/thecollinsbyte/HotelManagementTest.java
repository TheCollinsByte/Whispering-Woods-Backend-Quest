package com.thecollinsbyte;

import com.thecollinsbyte.booking.Booking;
import com.thecollinsbyte.guest.CorporateGuest;
import com.thecollinsbyte.guest.GroupBookingGuest;
import com.thecollinsbyte.guest.IndividualGuest;
import com.thecollinsbyte.guest.TravelAgencyGuest;
import com.thecollinsbyte.room.Room;
import com.thecollinsbyte.room.RoomType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HotelManagementTest {
    private Room room1, room2;
    private IndividualGuest individualGuest;
    private CorporateGuest corporateGuest;
    private TravelAgencyGuest travelAgencyGuest;
    private GroupBookingGuest groupBookingGuest;

    @BeforeEach
    void setUp() {
        room1 = new Room(101, RoomType.Deluxe, 150.0);
        room2 = new Room(102, RoomType.Single, 80.0);

        individualGuest = new IndividualGuest("John", "TZ12345");
        corporateGuest = new CorporateGuest("Tech Corp", "John Doe");

        travelAgencyGuest = new TravelAgencyGuest("Travel Experts");
        travelAgencyGuest.addClient(new IndividualGuest("Alice", "ID001"));
        travelAgencyGuest.addClient(new IndividualGuest("Bob", "ID002"));

        groupBookingGuest = new GroupBookingGuest("Family Trip");
        groupBookingGuest.addMember(new IndividualGuest("Charlie", "ID003"));
        groupBookingGuest.addMember(new IndividualGuest("David", "ID004"));
    }

    @Test
    void testIndividualGuestDetails() {
        String expected = "Individual: John (ID: TZ12345)";
        assertEquals(expected, individualGuest.getGuestDetails());
    }

    @Test
    void testCorporateGuestDetails() {
        String expected = "Corporate: Tech Corp (Contact: John Doe)";
        assertEquals(expected, corporateGuest.getGuestDetails());
    }

    @Test
    void testTravelAgencyGuestDetails() {
        String expected = "Travel Agency: Travel Experts\nClients:" +
                "\n  - Individual: Alice (ID: ID001)" +
                "\n  - Individual: Bob (ID: ID002)";
        assertEquals(expected, travelAgencyGuest.getGuestDetails());
    }

    @Test
    void testGroupBookingGuestDetails() {
        String expected = "Group: Family Trip\nMembers:" +
                "\n  - Individual: Charlie (ID: ID003)" +
                "\n  - Individual: David (ID: ID004)";
        assertEquals(expected, groupBookingGuest.getGuestDetails());
    }

    @Test
    void testRoomBooking() {
        assertTrue(room1.isAvailable());
        Booking booking = new Booking(individualGuest, room1);
        assertFalse(room1.isAvailable());
    }

    @Test
    void testBookingForTravelAgency() {
        Booking booking = new Booking(travelAgencyGuest, room1);
        String expectedBooking = "Booking confirmed for " +
                "Travel Agency: Travel Experts\nClients:" +
                "\n  - Individual: Alice (ID: ID001)" +
                "\n  - Individual: Bob (ID: ID002) in " + room1;
        assertTrue(booking.getBookingDetails().startsWith("Booking confirmed for Travel Agency"));
    }

    @Test
    void testGroupBooking() {
        Booking booking = new Booking(groupBookingGuest, room2);
        String expectedBooking = "Booking confirmed for " +
                "Group: Family Trip\nMembers:" +
                "\n  - Individual: Charlie (ID: ID003)" +
                "\n  - Individual: David (ID: ID004) in " + room2;
        assertTrue(booking.getBookingDetails().startsWith("Booking confirmed for Group"));
    }
}

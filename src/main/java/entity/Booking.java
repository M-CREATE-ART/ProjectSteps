package entity;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    private int bookingID;
    List<Person> persons = new ArrayList<>();
    Flight flight;
    User user;
    AirWays destination;

    public Booking(int bookingID, List<Person> persons, Flight flight, User user, AirWays destination) {
        this.bookingID = bookingID;
        this.persons = persons;
        this.flight = flight;
        this.user = user;
        this.destination = destination;
    }
}

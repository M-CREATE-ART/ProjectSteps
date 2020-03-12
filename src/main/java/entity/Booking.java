package entity;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    private int bookingID;
    List<Person> persons = new ArrayList<>();
    Flight flight;
    User user;

    public Booking(int bookingID, List<Person> persons, Flight flight, User user) {
        this.bookingID = bookingID;
        this.persons = persons;
        this.flight = flight;
        this.user = user;

    }

    public int getBookingID() {
        return bookingID;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Flight getFlight() {
        return flight;
    }

    public User getUser() {
        return user;
    }

    public String represent() {
        return null;
    }

}

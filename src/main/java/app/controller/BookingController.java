package app.controller;

import app.entities.Booking;
import app.entities.Person;
import app.service.BookingService;

import java.util.Collection;
import java.util.List;

public class BookingController {
    BookingService bookingService = new BookingService();

    public String addBooking(int ID, List<Person> passengers) {
        return bookingService.addBooking(ID, passengers);
    }

    public Collection<Booking> getAllBooking() {
        return bookingService.getAllBooking();
    }

    public Booking getBookingByID(int id) {
        return bookingService.getBookingByID(id);
    }

    public void saveBooking() {
        bookingService.saveBooking();
    }

    public boolean deleteBooking(Booking booking) {
        return bookingService.deleteBooking(booking);
    }

    public String cancelBooking(int ID) {
        return bookingService.cancelBooking(ID);
    }

    public String getMyFlights(String name, String surname) {
        return bookingService.getMyFlights(name, surname);
    }
}

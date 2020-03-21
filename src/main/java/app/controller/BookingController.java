package app.controller;

import app.entities.Booking;
import app.entities.Flight;
import app.entities.Person;
import app.service.BookingService;

import java.util.List;

public class BookingController {
    BookingService bookingService = new BookingService();

    public String addBooking(Flight flight, List<Person> passengers) {
        return bookingService.addBooking(flight, passengers);
    }

    public List<Booking> getAllBooking() {
        return bookingService.getAllBooking();
    }

    public Booking getBookingByID(int id) {
        return bookingService.getBookingByID(id);
    }

    public void saveBooking() {
        bookingService.saveBooking();
    }

    public boolean deleteBooking(int bookingId) {
        return bookingService.deleteBooking(bookingId);
    }

    public String cancelBooking(int ID) {
        return bookingService.cancelBooking(ID);
    }

    public String getMyFlights(String name, String surname) {
        return bookingService.getMyFlights(name, surname);
    }

    public void getfromDB() {
        bookingService.getfromDB();
    }
}

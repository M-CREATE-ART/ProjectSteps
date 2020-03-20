package app.service;

import app.dao.BookingDao;
import app.dao.FlightDao;
import app.entities.Booking;
import app.entities.Flight;
import app.entities.Person;

import java.util.Collection;
import java.util.List;

public class BookingService {
    BookingDao bookingDao = new BookingDao();
    FlightDao flightDao = new FlightDao();

    public String addBooking(int ID, List<Person> passengers) {
        try{
            Flight flight = flightDao.getByID(ID);
            flight.setFreeSeats(flight.getFreeSeats() - passengers.size());
            Booking booking = new Booking(getAllBooking().size(), flight, passengers);
            bookingDao.add(booking);
            return "Your booking has been completed successfully. See you on flight day <3! \n";
        }
        catch (Exception e){
            return "Your chosen flight doesn't exist, sorry!!! \n";
        }

    }

    public Collection<Booking> getAllBooking() {
        return bookingDao.getAll();
    }

    public Booking getBookingByID(int id) {
        return bookingDao.getByID(id);
    }

    public void saveBooking() {
        bookingDao.save();
    }

    public boolean deleteBooking(Booking booking) {
        return bookingDao.delete(booking);
    }

    public String cancelBooking(int ID) {
        try {
            int flightID = bookingDao.getByID(ID).getFlight().getID();
            int currentFreeSeats = bookingDao.getByID(ID).getFlight().getFreeSeats();
            int currentReservedSeats = bookingDao.getByID(ID).getPassengers().size();

            flightDao.getByID(flightID).setFreeSeats(currentFreeSeats + currentReservedSeats);
            deleteBooking(bookingDao.getByID(ID));

            return "Your booking cancelled successfully!";
        } catch (Exception e) {
            return "You entered invalid input!";
        }
    }

    public String getMyFlights(String name, String surname) {
        StringBuilder myFlights = new StringBuilder();
        Person person = new Person(name, surname);
        getAllBooking().stream()
                .filter(bk -> bk.getPassengers().contains(person))
                .forEach(mf-> myFlights.append(mf));

        return myFlights.toString();
    }

}

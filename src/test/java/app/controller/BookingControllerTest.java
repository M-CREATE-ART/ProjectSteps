package app.controller;

import app.database.Airport;
import app.entities.Booking;
import app.entities.Flight;
import app.entities.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingControllerTest {
  FlightController flightController;
  BookingController bookingController;


  @BeforeEach
  void setUp() {
    flightController = new FlightController();
    bookingController = new BookingController();


    Flight flightDemo = new Flight(1, Airport.BAHRAIN, "21/03/2020", 50, 0);
    Flight flightDemo2 = new Flight(2, Airport.GANDJA, "23/03/2020", 50, 0);
    flightController.getAllFlights().add(flightDemo);
    flightController.getAllFlights().add(flightDemo2);

    List<Person> passengers = new ArrayList<>();
    passengers.add(new Person("Maryam", "Mammadzadeh"));
    passengers.add(new Person("Gulshan", "Mammadzadeh"));

    Booking bookingDemo = new Booking(1, flightDemo, passengers);
    Booking bookingDemo2 = new Booking(2, flightDemo2, passengers);
    bookingController.getAllBooking().add(bookingDemo);
    bookingController.getAllBooking().add(bookingDemo2);
  }

  @Test
  void addBooking() {
    int initialSize = bookingController.getAllBooking().size();

    Flight flightDemo3 = new Flight(2, Airport.ANKARA, "23/03/2020", 50, 0);
    List<Person> passengers = new ArrayList<>();
    passengers.add(new Person("Maryam", "Mammadzadeh"));
    bookingController.addBooking(flightDemo3, passengers);

    int finalSize = bookingController.getAllBooking().size();

    boolean expected = true;
    boolean actual = initialSize<finalSize;


  }

  @Test
  void getAllBooking() {
    int expected = 2;
    int actual = bookingController.getAllBooking().size();

    assertEquals(expected, actual);


  }

  @Test
  void getBookingByID() {
    Booking expected = bookingController.getBookingByID(1);
    Booking actual = bookingController.getAllBooking().get(0);

    assertEquals(expected, actual);
  }


  @Test
  void deleteBooking() {
    List<Person> passengers = new ArrayList<>();
    passengers.add(new Person("Maryam", "Mammadzadeh"));
    passengers.add(new Person("Gulshan", "Mammadzadeh"));
    Flight flightDemo2 = new Flight(2, Airport.GANDJA, "23/03/2020", 50, 0);


    Booking bookingDemo2 = new Booking(2, flightDemo2, passengers);
    bookingController.getAllBooking().add(bookingDemo2);
    boolean expected = true;
    boolean actual = bookingController.deleteBooking(bookingDemo2.getID());

    assertEquals(expected, actual);
  }

  @Test
  void cancelBooking() {
    List<Person> passengers = new ArrayList<>();
    passengers.add(new Person("Maryam", "Mammadzadeh"));
    passengers.add(new Person("Gulshan", "Mammadzadeh"));
    Flight flightDemo2 = new Flight(2, Airport.GANDJA, "23/03/2020", 50, 0);
    Booking bookingDemo2 = new Booking(2, flightDemo2, passengers);
    bookingController.getAllBooking().add(bookingDemo2);
    int initialSize=bookingController.getAllBooking().size();
    bookingController.cancelBooking(2);
    int finalSize= bookingController.getAllBooking().size();
    boolean expected= true;
    boolean actual= initialSize>finalSize? true: false;
    assertEquals(expected, actual);
  }

  @Test
  void getMyFlights() {
    List<Person> passengers = new ArrayList<>();
    passengers.add(new Person("Maryam", "Mammadzadeh"));
    passengers.add(new Person("Gulshan", "Mammadzadeh"));
    Flight flightDemo2 = new Flight(2, Airport.GANDJA, "23/03/2020", 50, 0);
    Booking bookingDemo2 = new Booking(2, flightDemo2, passengers);
    String expected = "Booking ID: 1 Flight info: Flight ID: 1 FROM 'KYIV (KBP)' TO: 'BAHRAIN (BAH)' Flight date: '21/03/2020' Total seats: '50' Free seats: '0'\n" +
            " Passengers: [Maryam-Mammadzadeh, Gulshan-Mammadzadeh]Booking ID: 2 Flight info: Flight ID: 2 FROM 'KYIV (KBP)' TO: 'GANDJA (KVD)' Flight date: '23/03/2020' Total seats: '50' Free seats: '0'\n" +
            " Passengers: [Maryam-Mammadzadeh, Gulshan-Mammadzadeh]";
    String actual = bookingController.getMyFlights("Maryam", "Mammadzadeh");
    assertEquals(expected, actual);

  }

}
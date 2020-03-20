package controller;

import app.controller.FlightController;
import app.database.Airport;
import app.entities.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightControllerTest {
    FlightController flightController;

    @BeforeEach
    void setUp() {
        flightController = new FlightController();

        Flight flightDemo = new Flight(1, Airport.SOFIA, "20/03/2020", 50, 0);
        Flight flightDemo2 = new Flight(2, Airport.GANDJA, "23/03/2020", 50, 0);
        flightController.getAllFlights().add(flightDemo);
        flightController.getAllFlights().add(flightDemo2);

    }


    @Test
    void addFlight() {
        int initialSize = flightController.getAllFlights().size();
        flightController.addFlight(Airport.GANDJA, "23/03/2020|23:05", 15);
        int finalSize = flightController.getAllFlights().size();

        boolean expected = true;
        boolean actual = initialSize<finalSize;

        assertEquals(expected, actual);
    }

    @Test
    void getAllFlights() {
        int expected = 2;
        int actual = flightController.getAllFlights().size();

        assertEquals(expected, actual);
    }

    @Test
    void getFlightsByID() {
        Flight expected = flightController.getFlightsByID(1);
        Flight actual = flightController.getAllFlights().get(0);

        assertEquals(expected, actual);
    }


    @Test
    void deleteFlight() {
        Flight flight = new Flight(5, Airport.ANKARA, "25/03/2020|23:07", 5, 5);
        flightController.getAllFlights().add(flight);
        boolean expected = true;
        boolean actual = flightController.deleteFlight(flight);

        assertEquals(expected, actual);

    }


    @Test
    void getCurrentDayFlights() {
    }

    @Test
    void getfromDB() {
    }

    @Test
    void showFlightInfo() {
    }

    @Test
    void getFilteredFlights() {
    }
}
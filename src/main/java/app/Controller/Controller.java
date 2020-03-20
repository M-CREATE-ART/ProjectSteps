package app.Controller;

import app.IO.Console;
import app.service.Service;
import app.service.FlightService;

import java.io.IOException;

public class Controller {
    Service service;
    Console console;

    public static void main(String[] args) {
        FlightService flightservice = new FlightService();
        System.out.println(flightservice.generating());

    }

    public Controller(Console console, Service service) {
        this.service = service;
        this.console = console;
    }

    public void show() throws IOException {
        service.getallFlights();
    }

    public void search( String searchFligtID, String  searchFlightDestination, String  searchFlightSit ) throws IOException {
        service.searchingFlight(searchFligtID, searchFlightDestination,  searchFlightSit);
    }


    public void book(String flightDestination1, String flightId, String flightSit) {
        service.bookingFlight(flightDestination1, flightId, flightSit);
        // console.printLn(" ");


    }


}

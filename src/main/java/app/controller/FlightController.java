package app.controller;

import app.database.Airport;
import app.entities.Flight;
import app.service.FlightService;

import java.util.List;

public class FlightController {
    FlightService flightService = new FlightService();

    public void addFlight(Airport destination, String Date, int seats) {
        flightService.addFlight(destination, Date, seats);
    }

    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    public Flight getFlightsByID(int id) {
        return flightService.getFlightsByID(id);
    }

    public void saveFlight() {
        flightService.saveFlight();
    }

    public boolean deleteFlight(int flightId) {
        return flightService.deleteFlight(flightId);
    }

    public void generateFlight() {
        flightService.generateFlight();
    }

    public String getCurrentDayFlights() {
        return flightService.getCurrentDayFlights();
    }

    public void getfromDB() {
        flightService.getfromDB();
    }

    public String showFlightInfo(int ID) {
        return flightService.showFlightInfo(ID);
    }

    public String getFilteredFlights(String destination, String date, int passengers) {
        return flightService.getFilteredFlights(destination, date, passengers);
    }
}

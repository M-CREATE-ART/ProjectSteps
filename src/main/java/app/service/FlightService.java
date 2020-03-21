package app.service;


import app.dao.FlightDao;
import app.database.Airport;
import app.entities.Flight;
import app.util.Tools;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    FlightDao flightDao = new FlightDao();

    public void addFlight(Airport destination, String Date, int seats) {
        getAllFlights().add(new Flight(getAllFlights().size()+1, destination, Date, seats, seats));
    }

    public List<Flight> getAllFlights() {
        return flightDao.getAll();
    }

    public Flight getFlightsByID(int id) {
        return flightDao.getByID(id);
    }

    public void saveFlight() {
        flightDao.save();
    }

    public boolean deleteFlight(int flightId) {
        return flightDao.delete(flightId);
    }

    public void generateFlight() {
        String fileName = "src/main/java/app/database/flights.txt";
        List<String> lineList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            lineList = br.lines().collect(Collectors.toList());
            if (lineList.size() == 0) {
                FileWriter fw = new FileWriter(fileName);

                for (Flight flight : Tools.flightGenerator(50)) {
                    fw.write(flight + System.lineSeparator());
                }
                fw.close();
            }

        } catch (IOException ex) {
            System.out.printf(" %s File not found! \n", fileName);

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
                for (Flight flight : Tools.flightGenerator(50)) {
                    bw.write(flight + System.lineSeparator());
                }
                bw.close();
            } catch (IOException ex1) {
                System.out.println("Something went wrong!");
            }
        }

    }

    public String getCurrentDayFlights() {
        ArrayList<Flight> currentDayFlights = new ArrayList<>();
        StringBuilder currentDayFlightString = new StringBuilder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd|HH:mm");
        LocalDate currentDate = LocalDate.now().plusDays(1);

        for (Flight flight : flightDao.getAll()) {
            LocalDate flightDate = LocalDate.parse(flight.getDate(), formatter);

            if (currentDate.getMonth() == flightDate.getMonth() &&
                    currentDate.getDayOfMonth() >= flightDate.getDayOfMonth()
            ) currentDayFlights.add(flight);

        }

//        currentDayFlights = flightDao.getAll().stream().map(fl -> {
//            LocalDate flightDate = LocalDate.parse(fl.getDate(), formatter);
//
//            currentDate.getMonth() == flightDate.getMonth() && currentDate.getDayOfMonth() >= flightDate.getDayOfMonth();
//        }).collect(Collectors.toList());

        currentDayFlights.forEach(flight -> currentDayFlightString.append(flight.represent()));
        return currentDayFlightString.toString();
    }

    public void getfromDB() {
        flightDao.getfromDB();
    }

    public String showFlightInfo(int ID) {
        return getFlightsByID(ID).represent();
    }

    public String getFilteredFlights(String destination, String date, int passengers) {
        ArrayList<Flight> filteredFlights = new ArrayList<>();
        StringBuilder fliteredFlightString = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd|HH:mm");
        LocalDate searchDate = LocalDate.parse(date, formatter);

        flightDao.getAll().forEach(flight -> {

            LocalDate flightDate = LocalDate.parse(flight.getDate(), formatter2);
            if (flight.getDestination() == Airport.valueOf(destination.toUpperCase()) &&
                    searchDate.getMonth() == flightDate.getMonth() &&
                    searchDate.getDayOfMonth() == flightDate.getDayOfMonth() &&
                    flight.getFreeSeats() >= passengers) {
                filteredFlights.add(flight);
            }
        });
        filteredFlights.forEach(sf -> fliteredFlightString.append(sf.represent()));
        return fliteredFlightString.toString();
    }


}


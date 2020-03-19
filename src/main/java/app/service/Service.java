package app.service;

import app.Controller.Controller;
import app.DAOFull.BookingDAO;
import app.IO.Console;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Service {
    Service service;
    Console console;
    BookingDAO daoBooking;
    private Controller controller;

    public Service(BookingDAO daoBooking) {
        this.daoBooking = daoBooking;
    }

    public Service() {

    }


    public void getallFlights() throws IOException {
        String fileName = "flight.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    public void searchingFlight(String flightDestination) throws IOException{
        String fileName = "flight.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
    public void bookingFlight(String flightDestination1, String flightId,String flightSit) {
        System.out.println("Insert flightId,flightDestination, flightSit");
       // Console console;
        String fligtID = console.readLn();
        String flightDestination = console.readLn();
        String flightSitBook = console.readLn();

       // controller.search(fligtID, flightDestination, flightSitBook);
    }
}

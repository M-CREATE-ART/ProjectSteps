package app.service;

import app.DAOFull.BookingDAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Service {

    BookingDAO daoBooking;

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

    public void getSearchingFlight(String flightId) throws IOException{
        String fileName = "flight.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);

        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

}

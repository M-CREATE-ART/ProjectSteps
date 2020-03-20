package app.service;

import app.Controller.Controller;
import app.DAOFull.BookingDAO;
import app.IO.Console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Service {
    Service service;
    Console console;
    BookingDAO daoBooking;
    private Controller controller;
    FlightService flightSearch;

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

    public void searchingFlight( String searchFligtID, String  searchFlightDestination, String  searchFlightSit) throws IOException{
        List<String> listSearch = new ArrayList<String>();
        listSearch=flightSearch.convert();
        List<String> listFound = new ArrayList<String>();
for(String str:listSearch){
    if (listSearch.containsAll(Arrays.asList(searchFligtID, searchFlightDestination, searchFlightSit))) {
     listFound.add(str);
    }

}
        for(String str1:listFound){
            System.out.println(str1);
            }

        System.out.println();

    }



    public void bookingFlight(String flightDestination1, String flightId,String flightSit) {



    }
}

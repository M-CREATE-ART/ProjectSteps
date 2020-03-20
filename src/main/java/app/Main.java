package app;

import app.Controller.Controller;
import app.DAOFull.BookingDAO;
import app.IO.ConsoleMain;
import app.service.Service;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleMain console = new ConsoleMain();
        BookingDAO daoBooking = new BookingDAO();

        Service service = new Service(daoBooking);
    //    FlightService fs=new FlightService();
     //   fs.generating();
        Controller controller = new Controller(console, service);

        boolean w_loop = true;
        while (w_loop) {


            System.out.println("Select 1: 1 Show:  2 Search: 3 Book: 4 Exit ");

            System.out.println("Please enter your choice: 1 Show:  2 Search: 3 Book: 4 Exit ");

            String input = console.readLn();
            switch (input) {
                case "1":
                    controller.show();
                    break;
                case "2":

                    System.out.println("Insert flightId, flightDestination, flightSit");
                    String searchFligtID = console.readLn();
                    String searchFlightDestination = console.readLn();
                    String searchFlightSit = console.readLn();
                    controller.search(searchFligtID, searchFlightDestination, searchFlightSit);
                    break;
                case "3":
                    System.out.println("Insert flightId, flightDestination, flightSit");
                    String fligtIdBook = console.readLn();
                    String flightDestination1 = console.readLn();
                    String flightSit = console.readLn();
                    controller.book(fligtIdBook, flightDestination1, flightSit);
                    break;
                case "4":
                    w_loop = false;
                    break;
                default:
                    System.out.println("Wrong select");
                    break;
            }
        }
    }

}

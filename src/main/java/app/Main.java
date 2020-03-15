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
        System.out.println("test");
        Service service = new Service(daoBooking);

        Controller controller = new Controller(console, service);
        boolean w_loop = true;
        while (w_loop) {

            System.out.println("Please enter your choice: 1 Show:  2 Search: 3 Book: 4 Exit ");
            String input = console.readLn();
            switch (input) {
                case "1":
                    controller.show();
                    break;
                case "2":
                    System.out.println("Enter your Flight ID");
                    String fligtID =console.readLn();
                    controller.search(fligtID);
                    break;
                case "3":
                    controller.book();
                   break;
                case "4":
                    w_loop = false;
                    break;
                default:
                    break;
            }
        }
    }

}

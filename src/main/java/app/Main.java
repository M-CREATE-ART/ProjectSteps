package app;

import Controller.Controller;
import DAOFull.BookingDAO;
import IO.ConsoleMain;
import service.Service;

public class Main {
    public static void main(String[] args) {
        ConsoleMain console = new ConsoleMain();
        BookingDAO daoBooking = new BookingDAO();
        Service service = new Service(daoBooking);
        Controller controller = new Controller(console, service);
        boolean w_loop = true;
        while (w_loop) {
            String input = console.readLn();
            switch (input) {
                case "1":
                    controller.show();
                    break;
                case "2":
                    controller.search();
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

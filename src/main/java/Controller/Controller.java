package Controller;

import IO.Console;
import service.Service;

public class Controller {
    Service service;
    Console console;

    public Controller(Console console, Service service) {
        this.service = service;
        this.console = console;
    }

    public void show() {
        service.getallFlights();
    }

    public void search() {
        console.readLn();
    }

    public void book() {
        console.printLn(" ");
    }

}

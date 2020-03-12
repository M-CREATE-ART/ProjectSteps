package entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID;
    private String name;
    private String surname;
    List<Flight> flights= new ArrayList();

    public User(int ID, String name, String surname, List<Flight> flights) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.flights = flights;
    }
}

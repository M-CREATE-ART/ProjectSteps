package entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID;
    private String name;
    private String surname;
    List<String> flights= new ArrayList();

    public User(int ID, String name, String surname, List<String> flights) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.flights = flights;
    }
}

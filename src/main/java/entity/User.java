package entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int ID;
    private String name;
    private String surname;
    List<String> flights= new ArrayList();

    public User(int ID, String name, String surname, List<String> flights) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.flights = flights;
    }
}

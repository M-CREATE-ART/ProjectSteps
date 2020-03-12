package entity;

public class Person {
     private  int personID;
     private  String name;
     private String surname;

    public Person(int ID, String name, String surname) {
        this.personID = personID;
        this.name = name;
        this.surname = surname;
    }

    public int getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}


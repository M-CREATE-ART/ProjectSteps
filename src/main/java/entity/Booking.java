package entity;

import java.util.ArrayList;
import java.util.List;

public class Booking {
   private int bookingID;
   List<Person> persons= new ArrayList<>();
   Flight flight;
   User user;

   public Booking(int flightID, List<Person> person) {
      this.bookingID = bookingID;
      this.persons = persons;
   }
}

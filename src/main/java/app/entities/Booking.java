package app.entities;

import java.util.List;

public class Booking {
  private int ID;
  private Flight flight;
  private List<Person> passengers;

  public Booking(int ID, Flight flight, List<Person> passengers) {
    this.ID = ID;
    this.flight = flight;
    this.passengers = passengers;
  }

  public int getID() {
    return ID;
  }

  public Flight getFlight() {
    return flight;
  }

  public List<Person> getPassengers() {
    return passengers;
  }

  public String represent() {
    return String.format("Booking ID: %d Flight info: %s Passengers: %s", ID, flight.represent(), passengers);
  }

  @Override
  public String toString() {
    return String.format("%d;%s;%s", ID, flight, passengers);
  }
}

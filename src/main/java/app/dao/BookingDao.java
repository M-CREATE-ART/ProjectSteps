package app.dao;

import app.database.Airport;
import app.entities.Booking;
import app.entities.Flight;
import app.entities.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingDao implements dao<Booking> {
  public List<Booking> bookings = new ArrayList<>();

  @Override
  public void add(Booking booking) {
    bookings.add(booking);
  }

  @Override
  public List<Booking> getAll() {

    return bookings;
  }

  @Override
  public Booking getByID(int id) {
    return bookings.get(id-1);
  }

  @Override
  public void save() {
    File file = new File("src/main/java/app/database/bookings.txt");

    try {
      new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      BufferedWriter bw = new BufferedWriter(new FileWriter(file));

      for (Booking booking : bookings) {
        bw.write(booking.toString());
        bw.write("\n");
      }
      bw.close();

    } catch (Exception e) {
      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (Booking booking : bookings) {
          bw.write(booking.toString());
          bw.write("\n");
        }

        bw.close();

      } catch (Exception e1) {
        System.out.println("Oops! Something went wrong!!! \n");
      }
    }

  }

  @Override
  public boolean delete(int bookingId) {
    if (bookingId > bookings.size() || bookingId < 0) return false;
    bookings.removeIf(bk -> bookingId == bk.getID());
    return true;
  }

  @Override
  public void getfromDB() {
    File file = new File("src/main/java/app/database/bookings.txt");

    try {
      List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
      lines.stream().map(line -> line.split(";")).forEach(split1 -> {

        String[] flightSplit = split1[1].split(" ");
        String[] personSplit = split1[2].split(", ");

        Flight flight = new Flight(Integer.parseInt(flightSplit[0]), Airport.valueOf(flightSplit[1]),
                flightSplit[2], Integer.parseInt(flightSplit[3]), Integer.parseInt(flightSplit[4]));

        List<Person> passengers = new ArrayList<>();
        for (String s : personSplit) {
          String[] p1 = s.split("-");
          String name = p1[0].replaceAll("\\[", "").replaceAll("]", "");
          String surname = p1[1].replaceAll("\\[", "").replaceAll("]", "");

          passengers.add(new Person(name, surname));
        }
        bookings.add(new Booking(bookings.size() + 1, flight, passengers));
      });

    } catch (IOException e) {
      System.out.printf(" Database file: '%s' not found! \n", file);
    }

  }
}

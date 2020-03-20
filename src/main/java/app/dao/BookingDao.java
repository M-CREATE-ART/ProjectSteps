package app.dao;

import app.entities.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookingDao implements dao<Booking> {
    List<Booking> bookings = new ArrayList<>();

    @Override
    public void add(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public Collection<Booking> getAll() {

        return bookings;
    }

    @Override
    public Booking getByID(int id) {
        return bookings.get(id);
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
    public boolean delete(Booking booking) {
        if (bookings.contains(bookings)) {
            bookings.remove(bookings);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void getfromDB() {

    }
}

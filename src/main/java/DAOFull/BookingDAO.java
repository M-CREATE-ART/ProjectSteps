package DAOFull;

import entity.Booking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class BookingDAO implements DAO<Booking> {
private File file;
    ArrayList<Booking> bookings = new ArrayList<>();

    public BookingDAO() {
        super();
    }

    @Override
    public Collection<Booking> getAll() {
        return bookings;
    }

    @Override
    public Optional<Booking> get(int ID) {

        return bookings.stream().filter(bookings -> ID == bookings.getBookingID()).findFirst();

    }

    @Override
    public Collection<Booking> getAllBy(Predicate<Booking> p) {
        return getAll().stream().filter(p).collect(Collectors.toList());
    }

    @Override
    public void creat(Booking data) {
        Collection<Booking> bookings = getAll();
        bookings.add(Booking);
        write(bookings);
    }

    private void write(Collection<Booking> bookings) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Booking b: bookings) {
                bw.write(b.represent());
                bw.write("\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException("DAO:write:IOException", ex);
        }
    }
    }


}

    @Override
    public void delete(int ID) {

    }
}

package DAOFull;

import entity.Booking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class BookingDAO implements DAO<Booking> {

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

        return bookings.stream().filter(bk -> ID == bk.getBookingID()).findFirst();

    }

    @Override
    public Collection<Booking> getAllBy(Predicate<Booking> p) {
        return null;
    }

    @Override
    public void creat(Booking data) {

    }

    @Override
    public void delete(int ID) {

    }
}

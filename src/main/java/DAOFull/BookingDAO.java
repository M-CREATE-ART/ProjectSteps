package DAOFull;

import entity.Booking;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;


public class BookingDAO implements DAO<Booking> {

    public BookingDAO() {
        super();
    }

    @Override
    public Collection<Booking> getAll() {
        return null;
    }

    @Override
    public Optional<Booking> get(int ID) {
        return Optional.empty();
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

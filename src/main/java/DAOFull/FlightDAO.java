package DAOFull;

import entity.Booking;
import entity.Flight;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class FlightDAO implements DAO<Flight> {
    ArrayList<Flight> flights = new ArrayList<>();

    public FlightDAO() {
        super();
    }

    @Override
    public Collection<Flight> getAll() {
        return flights;
    }

    @Override
    public Optional<Flight> get(int ID) {

        return flights.stream().filter(flights -> ID == flights.getFlightID()).findFirst();
    }

    @Override
    public Collection<Flight> getAllBy(Predicate<Flight> p) {
        return null;
    }

    @Override
    public void creat(Flight data) {

    }

    @Override
    public void delete(int ID) {

    }
}

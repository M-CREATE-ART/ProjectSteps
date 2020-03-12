package DAOFull;

import entity.Flight;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class FlightsDAO implements DAO<Flight> {
    public FlightsDAO() {
        super();
    }

    @Override
    public Collection<Flight> getAll() {
        return null;
    }

    @Override
    public Optional<Flight> get(int ID) {
        return Optional.empty();
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

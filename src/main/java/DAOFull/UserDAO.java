package DAOFull;

import entity.User;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class UserDAO implements DAO<User> {
    public UserDAO() {
        super();
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> get(int ID) {
        return Optional.empty();
    }

    @Override
    public Collection<User> getAllBy(Predicate<User> p) {
        return null;
    }

    @Override
    public void creat(User data) {

    }

    @Override
    public void delete(int ID) {

    }
}

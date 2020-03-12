package DAOFull;

import entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class UserDAO implements DAO<User> {
    List<User> users= new ArrayList<>();
    public UserDAO() {
        super();
    }

    @Override
    public Collection<User> getAll() {
        return users;
    }

    @Override
    public Optional<User> get(int ID) {
        return users.stream().filter(us -> ID == us.getUserID()).findFirst();
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

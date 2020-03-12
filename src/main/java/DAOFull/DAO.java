package DAOFull;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface DAO<T> {
    Collection<T> getAll();

    Optional<T> get(int ID);

    Collection<T> getAllBy(Predicate<T> p);

    void creat(T data);

    void delete(int ID);

}

package app.dao;

import java.util.Collection;

public interface dao<M> {
    void add(M m);
    Collection<M> getAll();
    M getByID(int M);
    void save();
    boolean delete(int Id);
    void getfromDB();
}

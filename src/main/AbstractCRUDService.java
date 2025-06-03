package main;

import java.sql.*;
        import java.util.*;

public abstract class AbstractCRUDService<T> {
    protected Connection conn;

    public AbstractCRUDService() {
        try {
            conn = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract void create(T obj);
    public abstract Optional<T> read(int id);
    public abstract void update(T obj);
    public abstract void delete(int id);

    public abstract List<T> readAll();
}

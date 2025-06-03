package main;

import java.sql.*;
import java.util.*;

public class DriverService extends AbstractCRUDService<Driver> {
    private static DriverService instance;

    private DriverService() { super(); }

    public static DriverService getInstance() {
        if (instance == null) instance = new DriverService();
        return instance;
    }

    @Override
    public void create(Driver driver) {
        String sql = "INSERT INTO driver (name, email, carNumber) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, driver.getName());
            stmt.setString(2, driver.getEmail());
            stmt.setString(3, driver.getCarNumber());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    driver.setId(generatedKeys.getInt(1));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Driver> read(int id) {
        String sql = "SELECT * FROM driver WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Driver(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("carNumber")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Driver getByEmail(String email) {
        String sql = "SELECT * FROM driver WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Driver(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("carNumber")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteByEmail(String email) {
        String sql = "DELETE FROM driver WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Driver driver) {
        String sql = "UPDATE driver SET name = ?, address = ? WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, driver.getName());
            stmt.setString(2, driver.getCarNumber());
            stmt.setString(3, driver.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM driver WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Driver> readAll() {
        List<Driver> list = new ArrayList<>();
        String sql = "SELECT * FROM driver";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Driver(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("carNumber")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
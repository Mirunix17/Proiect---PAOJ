package main;

import java.sql.*;
import java.util.*;

public class RestaurantService extends AbstractCRUDService<Restaurant> {
    private static RestaurantService instance;

    private RestaurantService() {
        super();
    }

    public static RestaurantService getInstance() {
        if (instance == null) {
            instance = new RestaurantService();
        }
        return instance;
    }

    @Override
    public void create(Restaurant restaurant) {
        String sql = "INSERT INTO restaurant (name, location) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, restaurant.getName());
            stmt.setString(2, restaurant.getLocation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Restaurant> read(int id) {
        String sql = "SELECT * FROM restaurant WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Restaurant(
                        rs.getString("name"),
                        rs.getString("location")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Restaurant restaurant) {
        String sql = "UPDATE restaurant SET location = ? WHERE name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, restaurant.getLocation());
            stmt.setString(2, restaurant.getName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM restaurant WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Restaurant> readAll() {
        List<Restaurant> list = new ArrayList<>();
        String sql = "SELECT * FROM restaurant";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Restaurant(
                        rs.getString("name"),
                        rs.getString("location")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void printAllRestaurants() {
        for (Restaurant r : readAll()) {
            System.out.println(r.getName() + " | Adresă: " + r.getLocation());
        }
    }

    public void deleteByName(String deleteName) {
        String sql = "DELETE FROM restaurant WHERE name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, deleteName);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

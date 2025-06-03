package main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RatingService extends AbstractCRUDService<Rating> {
    private static RatingService instance;

    private RatingService() { super(); }

    public static RatingService getInstance() {
        if (instance == null) instance = new RatingService();
        return instance;
    }

    @Override
    public void create(Rating rating) {
        String sql = "INSERT INTO rating (stars, comment, reviewerEmail, restaurantName) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, rating.getStars());
            stmt.setString(2, rating.getComment());
            stmt.setString(3, rating.getReviewerEmail());
            stmt.setString(4, rating.getRestaurantName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Rating> read(int rating_id) {
        String sql = "SELECT * FROM rating WHERE rating_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, rating_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Rating(
                        rs.getInt("stars"),
                        rs.getString("comment"),
                        rs.getString("reviewerEmail"),
                        rs.getString("restaurantName")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Rating rating) {
        String sql = "UPDATE rating SET stars = ?, comment = ? WHERE reviewerEmail = ? AND restaurantName = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, rating.getStars());
            stmt.setString(2, rating.getComment());
            stmt.setString(3, rating.getReviewerEmail());
            stmt.setString(4, rating.getRestaurantName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

    }

//    @Override
//    public void deleteByEmailAndRestaurant(String reviewerEmail, String restaurantName) {
//        String sql = "DELETE FROM rating WHERE reviewerEmail = ? AND restaurantName = ?";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, reviewerEmail);
//            stmt.setString(2, restaurantName);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    public List<Rating> getByReviewerEmail(String email) {
        List<Rating> ratings = new ArrayList<>();
        String sql = "SELECT * FROM rating WHERE reviewerEmail = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ratings.add(new Rating(
                        rs.getInt("stars"),
                        rs.getString("comment"),
                        rs.getString("reviewerEmail"),
                        rs.getString("restaurantName")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratings;
    }

    @Override
    public List<Rating> readAll() {
        List<Rating> ratings = new ArrayList<>();
        String sql = "SELECT * FROM rating";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ratings.add(new Rating(
                        rs.getInt("stars"),
                        rs.getString("comment"),
                        rs.getString("reviewerEmail"),
                        rs.getString("restaurantName")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ratings;
    }
}

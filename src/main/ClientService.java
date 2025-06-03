//package main;
//
//import java.sql.*;
//import java.util.*;
//
//public class ClientService extends AbstractCRUDService<Client> {
//    private static ClientService instance;
//
//    private ClientService() { super(); }
//
//    public static ClientService getInstance() {
//        if (instance == null) instance = new ClientService();
//        return instance;
//    }
//
//    @Override
//    public void create(Client client) {
//        String sql = "INSERT INTO clients (name, email, address) VALUES (?, ?, ?)";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, client.getName());
//            stmt.setString(2, client.getEmail());
//            stmt.setString(3, client.getAddress());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Optional<Client> read(int id) {
//        String sql = "SELECT * FROM clients WHERE id = ?";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, id);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return Optional.of(new Client(
//                        rs.getString("name"),
//                        rs.getString("email"),
//                        rs.getString("address")
//                ));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public void update(Client client) {
//        String sql = "UPDATE clients SET name = ?, address = ? WHERE email = ?";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setString(1, client.getName());
//            stmt.setString(2, client.getAddress());
//            stmt.setString(3, client.getEmail());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(int id) {
//        String sql = "DELETE FROM clients WHERE id = ?";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, id);
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<Client> readAll() {
//        List<Client> list = new ArrayList<>();
//        String sql = "SELECT * FROM clients";
//        try (Statement stmt = conn.createStatement()) {
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                list.add(new Client(
//                        rs.getString("name"),
//                        rs.getString("email"),
//                        rs.getString("address")
//                ));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//
//}

package main;

import java.sql.*;
import java.util.*;

public class ClientService extends AbstractCRUDService<Client> {
    private static ClientService instance;

    private ClientService() { super(); }

    public static ClientService getInstance() {
        if (instance == null) instance = new ClientService();
        return instance;
    }

    @Override
    public void create(Client client) {
        String sql = "INSERT INTO client (name, email, address) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getAddress());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    client.setId(generatedKeys.getInt(1)); // presupunem că Client are un setter pentru ID
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Client> read(int id) {
        String sql = "SELECT * FROM client WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Client(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Client getByEmail(String email) {
        String sql = "SELECT * FROM client WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Client(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteByEmail(String email) {
        String sql = "DELETE FROM client WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client client) {
        String sql = "UPDATE client SET name = ?, address = ? WHERE email = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getAddress());
            stmt.setString(3, client.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> readAll() {
        List<Client> list = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Client(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("address")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
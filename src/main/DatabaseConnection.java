//package main;
//
//import java.sql.*;
//import java.util.*;
//import java.util.UUID;
//
//// --- Database Connection Singleton ---
//class DatabaseConnection {
//    private static DatabaseConnection instance;
//    private Connection connection;
//    private final String URL = "jdbc:mysql://localhost:3306/food_delivery";
//    private final String USER = "root";
//    private final String PASSWORD = "";
//
//    private DatabaseConnection() throws SQLException {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
//        } catch (ClassNotFoundException ex) {
//            throw new SQLException(ex);
//        }
//    }
//
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public static DatabaseConnection getInstance() throws SQLException {
//        if (instance == null || instance.getConnection().isClosed()) {
//            instance = new DatabaseConnection();
//        }
//        return instance;
//    }
//}
//

//package main;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DatabaseConnection {
//    private static final String URL = "jdbc:mysql://localhost:3306/paoj_proiect";
//    private static final String USER = "root";
//    private static final String PASSWORD = "";
//    private static Connection connection;
//
//    public DatabaseConnection() {}
//
//    public static Connection getConnection() {
//        if (connection == null) {
//            try {
//                connection = DriverManager.getConnection(URL, USER, PASSWORD);
//                System.out.println("Connected to database!");
//            } catch (SQLException e) {
//                System.out.println("Connection failed!");
//                e.printStackTrace();
//            }
//        }
//        return connection;
//    }
//}

package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/paoj_proiect";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Lasă gol dacă nu ai setată o parolă în XAMPP

    private static Connection connection;

    public DatabaseConnection() {}

    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
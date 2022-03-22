package com.example.dbpeople;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    public static Connection connection = null;

    /**
     * Method to establish a connection with the database
     * All the database info are got from the Constants class
     * May results in a SQLException if the connection cannot be done
     */

    static String URL = "jdbc:mysql://10.0.2.2:3306";
    static String database = "people";
    static String user = "matte";
    static String passwordDb = "11";

    public static void connect() {
        try {
            connection = DriverManager.getConnection(URL + "/" + database, user, passwordDb);

        } catch (SQLException ex) {
            System.out.println("ERROR CONNECTION WITH THE DATABASE");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}

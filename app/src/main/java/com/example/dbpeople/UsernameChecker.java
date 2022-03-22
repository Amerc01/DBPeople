package com.example.dbpeople;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsernameChecker {

    public boolean check(Connection con, String username) {
        ResultSet resultSet;
        try {
            Statement statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `peopledatas` WHERE username = " + username);
            resultSet.next();
            if (resultSet.getString(5).equals(username)) return true;
        } catch (SQLException exception) {
            return false;
        }
    return false;
    }
}

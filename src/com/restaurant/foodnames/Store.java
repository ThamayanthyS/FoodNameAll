package com.restaurant.foodnames;

/**
 * Created by Thamayanthy on 11/4/2014.
 */

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Store {
    public static boolean store(String name, String type, String tableName, Connection connection) {
        boolean inserted = false;

        PreparedStatement statement = null;
// FileInputStream inputStream = null;
        String query = "";
        query = "insert into " + tableName + "(food_name, food_type) "
                + "values(?,?);";
        try {
            // System.out.println(name+" "+type);

            statement = (PreparedStatement) connection.prepareStatement(query);
            // System.out.println(statement.toString());
            statement.setString(1, name);
            statement.setString(2, type);

            statement.executeUpdate();
            System.out.println(statement.toString());

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return inserted;

    }
}

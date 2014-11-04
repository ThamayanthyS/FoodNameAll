package com.restaurant.foodnames;

/**
 * Created by Thamayanthy on 11/4/2014.
 */

import java.sql.Connection;

public class DataCollector {

    public static void main(String... args) {
        Connection con = JDBCConnector.getConnection();
        System.out.println(con);
        //JsoupParser.parse1(con);
        Copy.copyFromOneDataBaseToAnother("food_items_food_time_line","food_items_all");
    }
}
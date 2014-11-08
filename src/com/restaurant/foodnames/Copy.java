package com.restaurant.foodnames;

import java.sql.*;

/**
 * Created by Thamayanthy on 11/4/2014.
 */
public class Copy {
    public static void copyFromOneDataBaseToAnother(String from, String to){
       // Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");

        Connection m_Connection = JDBCConnector.getConnection();

        Statement m_Statement = null;
        try {
            m_Statement = m_Connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query="SELECT * FROM "+from;
        PreparedStatement preparedStatement = null;
        ResultSet m_ResultSet=null;
        try {
            //m_Connection.setAutoCommit(false);
            preparedStatement=m_Connection.prepareStatement(query);
            //preparedStatement.setNString(1,from);
            m_ResultSet = preparedStatement.executeQuery(query);

            while (m_ResultSet.next()) {
                String x=m_ResultSet.getString(1);
                System.out.println(m_ResultSet.getString(1) + ", ");
                //System.out.println(to);
                //if(x.length()>1&&)
                Store.store(x,"",to,m_Connection);
                //Store.store("sss","",to,m_Connection);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

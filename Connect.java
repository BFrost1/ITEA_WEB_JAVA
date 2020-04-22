package com.shop.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public static Connection connection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/shop?" + "user=root&password=&serverTimezone=UTC");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}

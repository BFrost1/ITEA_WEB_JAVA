package com.shop.connectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;


public class CountryDB {
    public static String INSERT = "INSERT INTO country (country) VALUES (?)";
    public static String SELECT_ID = "SELECT id, country FROM country WHERE country=";
    public static String SELECT_ALL = "SELECT country FROM country";
    public static String DELETE ="TRUNCATE TABLE country";


    public static boolean add(Set arrayCuontry) {
        Iterator iterator = arrayCuontry.iterator();
        boolean status = false;
        while (iterator.hasNext()) {
            String items = (String) iterator.next();
            if (searchId(items.replace("'","`")) == 0) {
                Connection con = Connect.connection();
                PreparedStatement stmt = null;
                try {
                    stmt = con.prepareStatement(INSERT);
                    stmt.setString(1, items);
                    stmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        con.close();
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return status;
    }
    public static int searchId(String country){
        Connection con = Connect.connection();
        Statement stmt = null;
        int id = 0;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ID + "'"+country+"'");
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return id;
    }
    public static ArrayList countryAll(){
        Connection con = Connect.connection();
        Statement stmt = null;
        ArrayList<String> arr = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                arr.add(rs.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }
    public static void deleteItems(){
        Connection con = Connect.connection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(DELETE);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

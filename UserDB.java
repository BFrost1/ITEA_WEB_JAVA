package com.shop.connectionDB;

import com.shop.user.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDB {
    public static String INSERT = "INSERT INTO users (login, password, firstName, lastName, age, gender, country, comments, termsOfService) VALUES (?,?,?,?,?,?,?,?,?)";
    public static String SELECT_ID = "SELECT id, login, password FROM users WHERE login=";
    public static String DELETE = "TRUNCATE TABLE users";


    public static boolean add(User user) {
        boolean status = false;
        if (searchUser(user.getLogin().replace("'","`")).size() == 0) {
                Connection con = Connect.connection();
                PreparedStatement stmt = null;
                try {
                    stmt = con.prepareStatement(INSERT);
                    stmt.setString(1, user.getLogin());
                    stmt.setString(2, user.getPassword());
                    stmt.setString(3, user.getFirstName());
                    stmt.setString(4, user.getLastName());
                    stmt.setInt(5, user.getAge());
                    stmt.setString(6, user.getGender());
                    stmt.setInt(7, CountryDB.searchId(user.getCountry()));
                    stmt.setString(8, user.getComments());
                    stmt.setString(9, user.getTermsOfService());
                    stmt.execute();
                    status = true;
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
        return status;
        }

    public static ArrayList searchUser(String login){
        Connection con = Connect.connection();
        Statement stmt = null;
        ArrayList arrayList = new ArrayList();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ID + "'"+login+"'");
            while (rs.next()) {
                arrayList.add(rs.getString("login"));
                arrayList.add(rs.getString("password"));
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
        return arrayList;
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

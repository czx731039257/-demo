package com.demo.dao;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SelectUser {
    public Set<User> select(String username, String pwd) {
        Set<User> set = new HashSet<User>();
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/internship?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "root");
            PreparedStatement pstmt = con.prepareStatement("select * from user where name=? and password=? ");
            pstmt.setString(1, username);
            pstmt.setString(2, pwd);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                String email = resultSet.getString(4);
                String phone = resultSet.getString(5);
                User user = new User(id, name, password, email, phone);
                set.add(user);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }
}

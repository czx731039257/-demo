package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DeleteMessage {
    public void delete(int messageid) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/internship?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "root");
            PreparedStatement pstmt = con.prepareStatement("delete from message where id=? ");
            pstmt.setInt(1, messageid);
            int i = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

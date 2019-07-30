package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateMessage {
    public void update(Message message){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/internship?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "root");
            PreparedStatement pstmt = con.prepareStatement("update message set id=?,label=?,detail=?,date_create=?,date_edit=?,user_id=? where id=?");
            pstmt.setInt(1, message.getId());
            pstmt.setString(2,message.getLabel());
            pstmt.setString(3,message.getDetail());
            pstmt.setString(4,message.getDate_create());
            pstmt.setString(5,message.getDate_edit());
            pstmt.setInt(6,message.getUser_id());
            pstmt.setInt(7,message.getId());
            int i = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

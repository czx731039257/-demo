package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertMessage {
    public void insert(Message message){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/internship?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "root");
            PreparedStatement pstmt = con.prepareStatement("insert into message(label,detail,date_create,date_edit,user_id) values(?,?,?,?,?)");
            pstmt.setString(1,message.getLabel());
            pstmt.setString(2,message.getDetail());
            pstmt.setString(3,message.getDate_create());
            pstmt.setString(4,message.getDate_edit());
            pstmt.setInt(5,message.getUser_id());
            int i = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package com.demo.dao;

import com.demo.dao.MysqlUtil;
import com.demo.dao.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUser {
    private Connection con=null;
    private PreparedStatement pstmt=null;

    public void update(User user){
        try {
            con = MysqlUtil.getConnection();
            pstmt = con.prepareStatement("update user set id=?,name=?,password=?,email=?,phone=? where id=?");
            pstmt.setInt(1,user.getId());
            pstmt.setString(2,user.getName());
            pstmt.setString(3,user.getPassword());
            pstmt.setString(4,user.getEmail());
            pstmt.setString(5,user.getPhone());
            pstmt.setInt(6,user.getId());
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

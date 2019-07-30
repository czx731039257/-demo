package com.demo.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectMessage {
    public Set<Message> selectByUserId(int userId){
        Set<Message> set=new HashSet<Message>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/internship?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "root");
            PreparedStatement pstmt = con.prepareStatement("select * from message where user_id=? ");
            pstmt.setInt(1, userId);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String label = resultSet.getString("label");
                String detail = resultSet.getString("detail");
                String date_create = resultSet.getString("date_create");
                String date_edit = resultSet.getString("date_edit");
                int user_id = resultSet.getInt("user_id");
                Message message=new Message(id,label,detail,date_create,date_edit,user_id);
                set.add(message);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }
    public List<Message> selectAll(){
//        Set<Message> set=new HashSet<Message>();
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/internship?serverTimezone=UTC";
//            Connection con = DriverManager.getConnection(url, "root", "root");
//            PreparedStatement pstmt = con.prepareStatement("select * from message ");
//            ResultSet resultSet = pstmt.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String label = resultSet.getString("label");
//                String detail = resultSet.getString("detail");
//                String date_create = resultSet.getString("date_create");
//                String date_edit = resultSet.getString("date_edit");
//                int user_id = resultSet.getInt("user_id");
//                Message message=new Message(id,label,detail,date_create,date_edit,user_id);
//                set.add(message);
//            }
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return set;

        List<Message> list=new ArrayList<Message>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/internship?serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "root");
            PreparedStatement pstmt = con.prepareStatement("select * from message ");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String label = resultSet.getString("label");
                String detail = resultSet.getString("detail");
                String date_create = resultSet.getString("date_create");
                String date_edit = resultSet.getString("date_edit");
                int user_id = resultSet.getInt("user_id");
                Message message=new Message(id,label,detail,date_create,date_edit,user_id);
                list.add(message);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;


    }

//    public PageBean findALL(int pageNumber,int pageSize){
//
//        int totalRecord=0;
//        List<Message> list=new ArrayList<Message>();
//        PageBean pageBean=null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/internship?serverTimezone=UTC";
//            Connection con = DriverManager.getConnection(url, "root", "root");
//            PreparedStatement preparedStatement = con.prepareStatement("select count(*) from message");
//            ResultSet resultSet1 = preparedStatement.executeQuery();
//            while(resultSet1.next()){
//                totalRecord=resultSet1.getInt(1);
//            }
//            pageBean=new PageBean(pageNumber,pageSize,totalRecord);
//
//            PreparedStatement pstmt = con.prepareStatement("select * from message limit ?,?");
//
//            pstmt.setInt(1,(pageNumber-1)*pageSize);
//            if(pageBean.getPageNumber()<pageBean.getTotalPage()){
//                pstmt.setInt(2,pageBean.getPageSize());
//            }else{
//                pstmt.setInt(2,pageBean.getTotalRecord()-((pageNumber-1)*pageBean.getPageSize()));
//            }
//
//            ResultSet resultSet = pstmt.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String label = resultSet.getString("label");
//                String detail = resultSet.getString("detail");
//                String date_create = resultSet.getString("date_create");
//                String date_edit = resultSet.getString("date_edit");
//                int user_id = resultSet.getInt("user_id");
//                Message message=new Message(id,label,detail,date_create,date_edit,user_id);
//                list.add(message);
//            }
//
//            pageBean.setData(list);
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return pageBean;
//    }
}

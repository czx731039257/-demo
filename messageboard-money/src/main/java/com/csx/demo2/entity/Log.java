package com.csx.demo2.entity;

public class Log {
    private String user_name;
    private Integer user_id;
    private String operation;
    private Integer time;
    private String result;
    private String date;
    private User user;

    public Log() {
    }

    public Log(String user_name, Integer user_id, String operation, Integer time, String result, String date) {
        this.user_name = user_name;
        this.user_id = user_id;
        this.operation = operation;
        this.time = time;
        this.result = result;
        this.date = date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Log{" +
                "user_name='" + user_name + '\'' +
                ", user_id=" + user_id +
                ", operation='" + operation + '\'' +
                ", time=" + time +
                ", result='" + result + '\'' +
                '}';
    }
}

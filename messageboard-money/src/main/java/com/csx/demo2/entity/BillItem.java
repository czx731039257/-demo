package com.csx.demo2.entity;

public class BillItem {
    private Integer id;
    private String type;
    private Double money;
    private Integer user_id;
    private String date;

    public BillItem(Integer id, String type, Double money, Integer user_id, String date) {
        this.id = id;
        this.type = type;
        this.money = money;
        this.user_id = user_id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", money=" + money +
                ", user_id=" + user_id +
                ", date='" + date + '\'' +
                '}';
    }
}

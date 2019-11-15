package com.csx.demo2.entity;


import java.io.Serializable;

public class Message implements Serializable {
    private static final long SerialVersionUID = 1L;
    private Integer id;
    private String label;
    private String detail;
    private String date_create;
    private String date_edit;
    private Integer user_id;
    private User user;

    public Message() {
    }

    public Message(String label, String detail, String date_create, String date_edit, Integer user_id, Integer group_id) {
        this.label = label;
        this.detail = detail;
        this.date_create = date_create;
        this.date_edit = date_edit;
        this.user_id = user_id;
        this.user.setId(user_id);
        this.user.setGroup_id(group_id);
    }

    public Message(String label, String detail, String date_create, String date_edit, Integer user_id) {
        this.label = label;
        this.detail = detail;
        this.date_create = date_create;
        this.date_edit = date_edit;
        this.user_id = user_id;
    }

    public Message(Integer id, String label, String detail, String date_create, String date_edit, Integer user_id) {
        this.id = id;
        this.label = label;
        this.detail = detail;
        this.date_create = date_create;
        this.date_edit = date_edit;
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getDate_edit() {
        return date_edit;
    }

    public void setDate_edit(String date_edit) {
        this.date_edit = date_edit;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", detail='" + detail + '\'' +
                ", date_create='" + date_create + '\'' +
                ", date_edit='" + date_edit + '\'' +
                ", user_id=" + user_id +
                ", user=" + user +
                '}';
    }
}

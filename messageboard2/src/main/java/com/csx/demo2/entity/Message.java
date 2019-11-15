package com.csx.demo2.entity;

import org.apache.ibatis.type.Alias;

public class Message {
    public int id;
    public String label;
    public String detail;
    public String date_create;
    public String date_edit;
    public int user_id;

    public Message() {

    }

    public Message(int id, String label, String detail, String date_create, String date_edit, int user_id) {
        this.id = id;
        this.label = label;
        this.detail = detail;
        this.date_create = date_create;
        this.date_edit = date_edit;
        this.user_id = user_id;
    }

    public Message(String label, String detail, String date_create, String date_edit, int user_id) {
        this.label = label;
        this.detail = detail;
        this.date_create = date_create;
        this.date_edit = date_edit;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
                '}';
    }
}

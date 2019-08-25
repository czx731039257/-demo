package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id;
    private String label;
    private String detail;
    private String date_create;
    private String date_edit;
    private Integer user_id;
    private User user;

    private Message(Builder builder) {
        setId(builder.id);
        setLabel(builder.label);
        setDetail(builder.detail);
        setDate_create(builder.date_create);
        setDate_edit(builder.date_edit);
        setUser_id(builder.user_id);
        setUser(builder.user);
    }


    public static class Builder {
        private Integer id;
        private String label;
        private String detail;
        private String date_create;
        private String date_edit;
        private Integer user_id;
        private User user;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder label(String val) {
            label = val;
            return this;
        }

        public Builder detail(String val) {
            detail = val;
            return this;
        }

        public Builder date_create(String val) {
            date_create = val;
            return this;
        }

        public Builder date_edit(String val) {
            date_edit = val;
            return this;
        }

        public Builder user_id(Integer val) {
            user_id = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}

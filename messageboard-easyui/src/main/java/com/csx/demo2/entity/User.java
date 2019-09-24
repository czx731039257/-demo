package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Integer group_id;
    private Integer count_message;
    private Double money;
    private Integer head_id;
    private Head head;

    private List<Role> roles;
    private List<Message> messages;
    private List<Head> heads;

    private User(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setPassword(builder.password);
        setEmail(builder.email);
        setPhone(builder.phone);
        setGroup_id(builder.group_id);
        setCount_message(builder.count_message);
        setMoney(builder.money);
        setHead_id(builder.head_id);
        setHead(builder.head);
        setRoles(builder.roles);
        setMessages(builder.messages);
        setHeads(builder.heads);
    }


    public static final class Builder {
        private Integer id;
        private String name;
        private String password;
        private String email;
        private String phone;
        private Integer group_id;
        private Integer count_message;
        private Double money;
        private Integer head_id;
        private Head head;
        private List<Role> roles;
        private List<Message> messages;
        private List<Head> heads;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder group_id(Integer val) {
            group_id = val;
            return this;
        }

        public Builder count_message(Integer val) {
            count_message = val;
            return this;
        }

        public Builder money(Double val) {
            money = val;
            return this;
        }

        public Builder head_id(Integer val) {
            head_id = val;
            return this;
        }

        public Builder head(Head val) {
            head = val;
            return this;
        }

        public Builder roles(List<Role> val) {
            roles = val;
            return this;
        }

        public Builder messages(List<Message> val) {
            messages = val;
            return this;
        }

        public Builder heads(List<Head> val) {
            heads = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

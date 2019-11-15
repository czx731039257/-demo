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
    private List<Role> roles;
    private List<Message> messages;
    private Integer count_message;
    private Integer headportrait_id;
    private HeadPortrait currentHeadPortrait;
    private List<HeadPortrait> headPortraits;
    private Double money;

    private User(Builder builder) {
        id = builder.id;
        name = builder.name;
        password = builder.password;
        email = builder.email;
        phone = builder.phone;
        group_id = builder.group_id;
        roles = builder.roles;
        messages = builder.messages;
        count_message = builder.count_message;
        headportrait_id = builder.headportrait_id;
        currentHeadPortrait = builder.currentHeadPortrait;
        headPortraits = builder.headPortraits;
        money = builder.money;
    }


    public static class Builder {
        private Integer id;
        private String name;
        private String password;
        private String email;
        private String phone;
        private Integer group_id;
        private List<Role> roles;
        private List<Message> messages;
        private Integer count_message;
        private Integer headportrait_id;
        private HeadPortrait currentHeadPortrait;
        private List<HeadPortrait> headPortraits;
        private Double money;

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

        public Builder roles(List<Role> val) {
            roles = val;
            return this;
        }

        public Builder messages(List<Message> val) {
            messages = val;
            return this;
        }

        public Builder count_message(Integer val) {
            count_message = val;
            return this;
        }

        public Builder headportrait_id(Integer val) {
            headportrait_id = val;
            return this;
        }

        public Builder currentHeadPortrait(HeadPortrait val) {
            currentHeadPortrait = val;
            return this;
        }

        public Builder headPortraits(List<HeadPortrait> val) {
            headPortraits = val;
            return this;
        }

        public Builder money(Double val) {
            money = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

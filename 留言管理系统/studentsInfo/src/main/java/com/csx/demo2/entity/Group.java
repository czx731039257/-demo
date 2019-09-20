package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    private Integer id;
    private String name;
    private List<User> users;

    private Group(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setUsers(builder.users);
    }


    public static final class Builder {
        private Integer id;
        private String name;
        private List<User> users;

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

        public Builder users(List<User> val) {
            users = val;
            return this;
        }

        public Group build() {
            return new Group(this);
        }
    }
}

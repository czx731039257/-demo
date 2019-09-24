package com.demo.sis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;

    private User(Builder builder) {
        setUsername(builder.username);
        setPassword(builder.password);
    }


    public static final class Builder {
        private String username;
        private String password;

        public Builder() {
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

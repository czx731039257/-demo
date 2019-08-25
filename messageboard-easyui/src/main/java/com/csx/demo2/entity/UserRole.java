package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    private Integer user_id;
    private Integer role_id;

    private UserRole(Builder builder) {
        setUser_id(builder.user_id);
        setRole_id(builder.role_id);
    }


    public static final class Builder {
        private Integer user_id;
        private Integer role_id;

        public Builder() {
        }

        public Builder user_id(Integer val) {
            user_id = val;
            return this;
        }

        public Builder role_id(Integer val) {
            role_id = val;
            return this;
        }

        public UserRole build() {
            return new UserRole(this);
        }
    }
}

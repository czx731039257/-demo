package com.csx.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer role_id;
    private String role_name;

    private Role(Builder builder) {
        setRole_id(builder.role_id);
        setRole_name(builder.role_name);
    }


    public static final class Builder {
        private Integer role_id;
        private String role_name;

        public Builder() {
        }

        public Builder role_id(Integer val) {
            role_id = val;
            return this;
        }

        public Builder role_name(String val) {
            role_name = val;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }
}

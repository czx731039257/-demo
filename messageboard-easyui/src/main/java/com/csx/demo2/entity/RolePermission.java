package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermission {
    private Integer role_id;
    private Integer permission_id;

    private RolePermission(Builder builder) {
        setRole_id(builder.role_id);
        setPermission_id(builder.permission_id);
    }


    public static final class Builder {
        private Integer role_id;
        private Integer permission_id;

        public Builder() {
        }

        public Builder role_id(Integer val) {
            role_id = val;
            return this;
        }

        public Builder permission_id(Integer val) {
            permission_id = val;
            return this;
        }

        public RolePermission build() {
            return new RolePermission(this);
        }
    }
}

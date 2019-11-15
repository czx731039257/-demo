package com.csx.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private Integer permission_id;
    private Integer permission_name;

    private Permission(Builder builder) {
        setPermission_id(builder.permission_id);
        setPermission_name(builder.permission_name);
    }


    public static final class Builder {
        private Integer permission_id;
        private Integer permission_name;

        public Builder() {
        }

        public Builder permission_id(Integer val) {
            permission_id = val;
            return this;
        }

        public Builder permission_name(Integer val) {
            permission_name = val;
            return this;
        }

        public Permission build() {
            return new Permission(this);
        }
    }
}

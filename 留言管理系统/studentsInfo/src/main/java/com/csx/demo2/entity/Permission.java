package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private Integer id;
    private String name;
    private List<Role> roles;

    private Permission(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setRoles(builder.roles);
    }


    public static final class Builder {
        private Integer id;
        private String name;
        private List<Role> roles;

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

        public Builder roles(List<Role> val) {
            roles = val;
            return this;
        }

        public Permission build() {
            return new Permission(this);
        }
    }
}

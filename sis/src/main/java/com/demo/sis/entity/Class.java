package com.demo.sis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    private Integer id;
    private String name;
    private Integer monitor_id;
    private Integer number;
    private String instructor;

    private Class(Builder builder) {
        id = builder.id;
        name = builder.name;
        monitor_id = builder.monitor_id;
        number = builder.number;
        instructor = builder.instructor;
    }


    public static final class Builder {
        private Integer id;
        private String name;
        private Integer monitor_id;
        private Integer number;
        private String instructor;

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

        public Builder monitor_id(Integer val) {
            monitor_id = val;
            return this;
        }

        public Builder number(Integer val) {
            number = val;
            return this;
        }

        public Builder instructor(String val) {
            instructor = val;
            return this;
        }

        public Class build() {
            return new Class(this);
        }
    }
}

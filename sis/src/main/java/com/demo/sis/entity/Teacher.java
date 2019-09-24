package com.demo.sis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String phone;

    private Teacher(Builder builder) {
        id = builder.id;
        name = builder.name;
        sex = builder.sex;
        age = builder.age;
        phone = builder.phone;
    }


    public static final class Builder {
        private Integer id;
        private String name;
        private String sex;
        private Integer age;
        private String phone;

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

        public Builder sex(String val) {
            sex = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Teacher build() {
            return new Teacher(this);
        }
    }
}

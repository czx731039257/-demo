package com.demo.sis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String major;
    private String phone;
    private Integer class_id;
    private Class c;

    private Student(Builder builder) {
        id = builder.id;
        name = builder.name;
        sex = builder.sex;
        age = builder.age;
        major = builder.major;
        phone = builder.phone;
        class_id = builder.class_id;
        c = builder.c;
    }


    public static final class Builder {
        private Integer id;
        private String name;
        private String sex;
        private Integer age;
        private String major;
        private String phone;
        private Integer class_id;
        private Class c;

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

        public Builder major(String val) {
            major = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder class_id(Integer val) {
            class_id = val;
            return this;
        }

        public Builder c(Class val) {
            c = val;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}


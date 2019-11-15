package com.csx.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer eno;
    private String name;
    private String sex;
    private Integer age;
    private String department_id;
    private String post;
    private String rank;
    private String phone;
    private String email;
    private String city;

    private Employee(Builder builder) {
        setEno(builder.eno);
        setName(builder.name);
        setSex(builder.sex);
        setAge(builder.age);
        setDepartment_id(builder.department_id);
        setPost(builder.post);
        setRank(builder.rank);
        setPhone(builder.phone);
        setEmail(builder.email);
        setCity(builder.city);
    }


    public static final class Builder {
        private Integer eno;
        private String name;
        private String sex;
        private Integer age;
        private String department_id;
        private String post;
        private String rank;
        private String phone;
        private String email;
        private String city;

        public Builder() {
        }

        public Builder eno(Integer val) {
            eno = val;
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

        public Builder department_id(String val) {
            department_id = val;
            return this;
        }

        public Builder post(String val) {
            post = val;
            return this;
        }

        public Builder rank(String val) {
            rank = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}

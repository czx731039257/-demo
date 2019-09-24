package com.demo.sis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Integer id;
    private String name;
    private String classroom;
    private String date;
    private Integer credit;
    private Integer teacher_id;

    private Course(Builder builder) {
        id = builder.id;
        name = builder.name;
        classroom = builder.classroom;
        date = builder.date;
        credit = builder.credit;
        teacher_id = builder.teacher_id;
    }


    public static final class Builder {
        private Integer id;
        private String name;
        private String classroom;
        private String date;
        private Integer credit;
        private Integer teacher_id;

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

        public Builder classroom(String val) {
            classroom = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public Builder credit(Integer val) {
            credit = val;
            return this;
        }

        public Builder teacher_id(Integer val) {
            teacher_id = val;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}

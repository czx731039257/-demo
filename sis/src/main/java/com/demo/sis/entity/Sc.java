package com.demo.sis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sc {
    private  Integer student_id;
    private Integer course_id;
    private Integer grade;

    private Sc(Builder builder) {
        setStudent_id(builder.student_id);
        setCourse_id(builder.course_id);
        setGrade(builder.grade);
    }


    public static final class Builder {
        private Integer student_id;
        private Integer course_id;
        private Integer grade;

        public Builder() {
        }

        public Builder student_id(Integer val) {
            student_id = val;
            return this;
        }

        public Builder course_id(Integer val) {
            course_id = val;
            return this;
        }

        public Builder grade(Integer val) {
            grade = val;
            return this;
        }

        public Sc build() {
            return new Sc(this);
        }
    }
}

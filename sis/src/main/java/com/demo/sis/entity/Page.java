package com.demo.sis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private Integer total;//集合中元素总个数
    private Integer pageNumber;//当前页码
    private Integer pageSize;//每页的行数
    private Integer startIndex;
    private Object rows;

    private Student student;
    private Course course;
    private Teacher teacher;
    private Class c;

    private Page(Builder builder) {
        setTotal(builder.total);
        setPageNumber(builder.pageNumber);
        setPageSize(builder.pageSize);
        setStartIndex(builder.startIndex);
        setRows(builder.rows);
        setStudent(builder.student);
        setCourse(builder.course);
        setTeacher(builder.teacher);
        setC(builder.c);
    }


    public static final class Builder {
        private Integer total;
        private Integer pageNumber;
        private Integer pageSize;
        private Integer startIndex;
        private Object rows;
        private Student student;
        private Course course;
        private Teacher teacher;
        private Class c;

        public Builder() {
        }

        public Builder total(Integer val) {
            total = val;
            return this;
        }

        public Builder pageNumber(Integer val) {
            pageNumber = val;
            return this;
        }

        public Builder pageSize(Integer val) {
            pageSize = val;
            return this;
        }

        public Builder startIndex(Integer val) {
            startIndex = val;
            return this;
        }

        public Builder rows(Object val) {
            rows = val;
            return this;
        }

        public Builder student(Student val) {
            student = val;
            return this;
        }

        public Builder course(Course val) {
            course = val;
            return this;
        }

        public Builder teacher(Teacher val) {
            teacher = val;
            return this;
        }

        public Builder c(Class val) {
            c = val;
            return this;
        }

        public Page build() {
            return new Page(this);
        }
    }
}

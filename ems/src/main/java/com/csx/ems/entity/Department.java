package com.csx.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer department_id;
    private String department_name;
    private Integer count;
    private String minister;

    private Department(Builder builder) {
        setDepartment_id(builder.department_id);
        setDepartment_name(builder.department_name);
        setCount(builder.count);
        setMinister(builder.minister);
    }


    public static final class Builder {
        private Integer department_id;
        private String department_name;
        private Integer count;
        private String minister;

        public Builder() {
        }

        public Builder department_id(Integer val) {
            department_id = val;
            return this;
        }

        public Builder department_name(String val) {
            department_name = val;
            return this;
        }

        public Builder count(Integer val) {
            count = val;
            return this;
        }

        public Builder minister(String val) {
            minister = val;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}

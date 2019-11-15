package com.csx.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private Integer log_id;
    private Integer employee_id;
    private String date;
    private String time;
    private String operation;

    private Log(Builder builder) {
        setLog_id(builder.log_id);
        setEmployee_id(builder.employee_id);
        setDate(builder.date);
        setTime(builder.time);
        setOperation(builder.operation);
    }


    public static final class Builder {
        private Integer log_id;
        private Integer employee_id;
        private String date;
        private String time;
        private String operation;

        public Builder() {
        }

        public Builder log_id(Integer val) {
            log_id = val;
            return this;
        }

        public Builder employee_id(Integer val) {
            employee_id = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public Builder time(String val) {
            time = val;
            return this;
        }

        public Builder operation(String val) {
            operation = val;
            return this;
        }

        public Log build() {
            return new Log(this);
        }
    }
}

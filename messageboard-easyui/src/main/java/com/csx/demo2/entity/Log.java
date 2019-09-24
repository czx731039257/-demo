package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer user_id;
    private String operation;
    private Integer time;
    private String result;
    private String date;
    private User user;

    private Log(Builder builder) {
        setUser_id(builder.user_id);
        setOperation(builder.operation);
        setTime(builder.time);
        setResult(builder.result);
        setDate(builder.date);
        setUser(builder.user);
    }


    public static final class Builder {
        private Integer user_id;
        private String operation;
        private Integer time;
        private String result;
        private String date;
        private User user;

        public Builder() {
        }

        public Builder user_id(Integer val) {
            user_id = val;
            return this;
        }

        public Builder operation(String val) {
            operation = val;
            return this;
        }

        public Builder time(Integer val) {
            time = val;
            return this;
        }

        public Builder result(String val) {
            result = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Log build() {
            return new Log(this);
        }
    }
}

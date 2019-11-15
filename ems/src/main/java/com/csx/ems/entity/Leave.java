package com.csx.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leave {
    private Integer leave_id;
    private Integer employee_id;
    private String date_start;
    private String date_end;
    private String reason;
    private String status;

    private Leave(Builder builder) {
        setLeave_id(builder.leave_id);
        setEmployee_id(builder.employee_id);
        setDate_start(builder.date_start);
        setDate_end(builder.date_end);
        setReason(builder.reason);
        setStatus(builder.status);
    }


    public static final class Builder {
        private Integer leave_id;
        private Integer employee_id;
        private String date_start;
        private String date_end;
        private String reason;
        private String status;

        public Builder() {
        }

        public Builder leave_id(Integer val) {
            leave_id = val;
            return this;
        }

        public Builder employee_id(Integer val) {
            employee_id = val;
            return this;
        }

        public Builder date_start(String val) {
            date_start = val;
            return this;
        }

        public Builder date_end(String val) {
            date_end = val;
            return this;
        }

        public Builder reason(String val) {
            reason = val;
            return this;
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public Leave build() {
            return new Leave(this);
        }
    }
}

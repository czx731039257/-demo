package com.csx.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private Integer notice_id;
    private String label;
    private String detail;
    private Integer department_id;
    private String date;

    private Notice(Builder builder) {
        setNotice_id(builder.notice_id);
        setLabel(builder.label);
        setDetail(builder.detail);
        setDepartment_id(builder.department_id);
        setDate(builder.date);
    }


    public static final class Builder {
        private Integer notice_id;
        private String label;
        private String detail;
        private Integer department_id;
        private String date;

        public Builder() {
        }

        public Builder notice_id(Integer val) {
            notice_id = val;
            return this;
        }

        public Builder label(String val) {
            label = val;
            return this;
        }

        public Builder detail(String val) {
            detail = val;
            return this;
        }

        public Builder department_id(Integer val) {
            department_id = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public Notice build() {
            return new Notice(this);
        }
    }
}

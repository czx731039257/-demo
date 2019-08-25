package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillItem {
    private Integer id;
    private String type;
    private Double money;
    private Integer user_id;
    private String date;

    private BillItem(Builder builder) {
        setId(builder.id);
        setType(builder.type);
        setMoney(builder.money);
        setUser_id(builder.user_id);
        setDate(builder.date);
    }


    public static final class Builder {
        private Integer id;
        private String type;
        private Double money;
        private Integer user_id;
        private String date;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder type(String val) {
            type = val;
            return this;
        }

        public Builder money(Double val) {
            money = val;
            return this;
        }

        public Builder user_id(Integer val) {
            user_id = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public BillItem build() {
            return new BillItem(this);
        }
    }
}

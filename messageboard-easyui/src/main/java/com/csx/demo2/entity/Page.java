package com.csx.demo2.entity;


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

    private Message message;
    private User user;
    private Log log;
    private BillItem billItem;
    private Object rows;

    private Page(Builder builder) {
        setTotal(builder.total);
        setPageNumber(builder.pageNumber);
        setPageSize(builder.pageSize);
        setStartIndex(builder.startIndex);
        setMessage(builder.message);
        setUser(builder.user);
        setLog(builder.log);
        setBillItem(builder.billItem);
        setRows(builder.rows);
    }


    public static final class Builder {
        private Integer total;
        private Integer pageNumber;
        private Integer pageSize;
        private Integer startIndex;
        private Message message;
        private User user;
        private Log log;
        private BillItem billItem;
        private Object rows;

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

        public Builder message(Message val) {
            message = val;
            return this;
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder log(Log val) {
            log = val;
            return this;
        }

        public Builder billItem(BillItem val) {
            billItem = val;
            return this;
        }

        public Builder rows(Object val) {
            rows = val;
            return this;
        }

        public Page build() {
            return new Page(this);
        }
    }
}

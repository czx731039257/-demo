package com.csx.demo2.entity;

import java.util.List;

public class Page {
    private Integer total;
    private Integer pageNumber;//页数
    private Integer pageSize;//每页的行数
    private Integer startIndex;
    private Message message;
    private List<Message> rows;//分页里的留言集合

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Message> getRows() {
        return rows;
    }

    public void setRows(List<Message> rows) {
        this.rows = rows;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}

package com.csx.demo2.entity;


public class PageBean {

    private int messagesType;//1表示个人留言  2表示同组留言   3表示其他组留言  4表示所有人的留言  5表示某个人
    private int pageNumber;//当前页码
    private static final int pageSize = 10;//每页的数据数
    private int totalRecord;//总记录数
    private int totalPage;//总页数
    private int startIndex;//开始索引
    private int endIndex;//结束索引

    public PageBean(int pageNumber, int totalRecord) {
        this.pageNumber = pageNumber;
        this.totalRecord = totalRecord;
        this.startIndex = (pageNumber - 1) * pageSize;
        if ((totalRecord / pageSize) * pageSize == totalRecord) {
            this.totalPage = totalRecord / pageSize;
        } else {
            this.totalPage = (int) (totalRecord / pageSize) + 1;
        }
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        startIndex = (pageNumber - 1) * pageSize;
        System.out.println("start:" + startIndex);
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        if (pageNumber < totalPage) {
            System.out.println("end:" + (pageNumber * pageSize - 1));
            return pageNumber * pageSize - 1;
        } else {
            System.out.println("end:" + (totalRecord - 1));
            return totalRecord - 1;
        }
    }

    public void addPageNumber() {
        pageNumber += 1;
    }

    public void minusPageNumber() {
        pageNumber -= 1;
    }

    public void addTotalRecord() {
        totalRecord += 1;
        if ((totalRecord / pageSize) * pageSize == totalRecord) {
            this.totalPage = totalRecord / pageSize;
        } else {
            this.totalPage = (int) (totalRecord / pageSize) + 1;
        }
    }

    public void minusTotalRecord() {
        if ((totalPage - 1) * pageSize + 1 == totalRecord) {
            if (pageNumber == totalPage) {
                pageNumber -= 1;
            }
            totalPage -= 1;
        }
        totalRecord -= 1;
    }

    public int getMessagesType() {
        return messagesType;
    }

    public void setMessagesType(int messagesType) {
        this.messagesType = messagesType;
    }
}

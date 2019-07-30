package com.demo.dao;

import java.util.List;

public class PageBean {
    private int pageNumber;//当前页码
    private int pageSize;//每页的数据数
    private int totalRecord;//总记录数
    private int totalPage;//总页数
    private int startIndex;//开始索引
    private int endIndex;//结束索引

    public PageBean(int pageNumber, int pageSize, int totalRecord) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.startIndex = (pageNumber-1)*pageSize;
        if((totalRecord/pageSize)*pageSize==totalRecord){
            this.totalPage=totalRecord/pageSize;
        }else{
            this.totalPage = (int)(totalRecord/pageSize)+1;
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

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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
        startIndex=(pageNumber-1)*pageSize;
        System.out.println("start:"+startIndex);
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex(){
        if(pageNumber<totalPage){
            return pageNumber*pageSize-1;
        }else{
            return totalRecord-1;
        }
    }

    public void addPageNumber(){
        pageNumber+=1;
    }

    public void minusPageNumber(){
        pageNumber-=1;
    }

    public void addTotalRecord(){
        totalRecord+=1;
        if((totalRecord/pageSize)*pageSize==totalRecord){
            this.totalPage=totalRecord/pageSize;
        }else{
            this.totalPage = (int)(totalRecord/pageSize)+1;
        }
    }

}

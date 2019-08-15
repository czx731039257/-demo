package com.csx.demo2.entity;

import java.util.List;

public class VerifyResult {

    private User user;
    private int flag;//用来判断登入情况  0表示没有该用户 1表示有该用户但是密码错误  2表示登入成功
    private PageBean pageBean;
    private List<Message> messages;
    private List<Permission> permissions;
    private String logmsg;

    public VerifyResult(User user, int flag, PageBean pageBean, List<Message> messages, List<Permission> permissions, String logmsg) {
        this.user = user;
        this.flag = flag;
        this.pageBean = pageBean;
        this.messages = messages;
        this.permissions = permissions;
        this.logmsg = logmsg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public String getLogmsg() {
        return logmsg;
    }

    public void setLogmsg(String logmsg) {
        this.logmsg = logmsg;
    }
}

package com.csx.demo2.entity;

import java.util.List;

public class Result {
    private User user;
    private boolean result;//true表示验证通过
    private PageBean pageBean;
    private List<Message> messages;
    private List<Permission> permissions;
    private String logmsg;

    public Result(User user, boolean result, PageBean pageBean, List<Message> messages, List<Permission> permissions) {
        this.user = user;
        this.result = result;
        this.pageBean = pageBean;
        this.messages = messages;
        this.permissions = permissions;
    }

    public Result(boolean result, User user, PageBean pageBean, List<Message> messages) {
        this.user = user;
        this.result = result;
        this.pageBean = pageBean;
        this.messages = messages;
    }

    public Result(boolean result, User user, PageBean pageBean, List<Message> messages, String logmsg) {
        this.user = user;
        this.result = result;
        this.pageBean = pageBean;
        this.messages = messages;
        this.logmsg = logmsg;
    }

    public Result() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
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

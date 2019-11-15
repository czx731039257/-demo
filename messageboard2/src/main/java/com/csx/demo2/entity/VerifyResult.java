package com.csx.demo2.entity;

public class VerifyResult {
    private User user;
    private boolean result;//true表示验证通过
    private PageBean pageBean;

    public VerifyResult(boolean result, User user, PageBean pageBean) {
        this.user = user;
        this.result = result;
        this.pageBean = pageBean;
    }

    public VerifyResult() {
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
}

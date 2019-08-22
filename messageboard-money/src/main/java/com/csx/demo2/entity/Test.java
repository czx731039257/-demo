package com.csx.demo2.entity;

public class Test {

    private String errorMsg;
    private String success;

    public Test() {
    }

    public Test(String errorMsg, String success) {
        this.errorMsg = errorMsg;
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}

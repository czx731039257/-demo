package com.csx.demo2.entity;

public class Method {
    private String method_url;
    private String method_name;

    public Method(String method_url, String method_name) {
        this.method_url = method_url;
        this.method_name = method_name;
    }

    public String getMethod_url() {
        return method_url;
    }

    public void setMethod_url(String method_url) {
        this.method_url = method_url;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }
}

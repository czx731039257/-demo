package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Method {
    private String method_url;
    private String method_name;

    private Method(Builder builder) {
        setMethod_url(builder.method_url);
        setMethod_name(builder.method_name);
    }


    public static final class Builder {
        private String method_url;
        private String method_name;

        public Builder() {
        }

        public Builder method_url(String val) {
            method_url = val;
            return this;
        }

        public Builder method_name(String val) {
            method_name = val;
            return this;
        }

        public Method build() {
            return new Method(this);
        }
    }
}

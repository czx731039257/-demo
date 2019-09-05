package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String successMsg;
    private String errorMsg;
    private String backUrl;

    private Result(Builder builder) {
        setSuccessMsg(builder.successMsg);
        setErrorMsg(builder.errorMsg);
        setBackUrl(builder.backUrl);
    }


    public static final class Builder {
        private String successMsg;
        private String errorMsg;
        private String backUrl;

        public Builder() {
        }

        public Builder successMsg(String val) {
            successMsg = val;
            return this;
        }

        public Builder errorMsg(String val) {
            errorMsg = val;
            return this;
        }

        public Builder backUrl(String val) {
            backUrl = val;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }
}

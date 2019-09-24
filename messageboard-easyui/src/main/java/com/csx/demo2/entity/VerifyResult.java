package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerifyResult {

    private User user;
    private PageBean pageBean;
    private List<Message> messages;
    private List<Permission> permissions;
    private String logmsg;

    private VerifyResult(Builder builder) {
        setUser(builder.user);
        setPageBean(builder.pageBean);
        setMessages(builder.messages);
        setPermissions(builder.permissions);
        setLogmsg(builder.logmsg);
    }


    public static final class Builder {
        private User user;
        private PageBean pageBean;
        private List<Message> messages;
        private List<Permission> permissions;
        private String logmsg;

        public Builder() {
        }

        public Builder user(User val) {
            user = val;
            return this;
        }

        public Builder pageBean(PageBean val) {
            pageBean = val;
            return this;
        }

        public Builder messages(List<Message> val) {
            messages = val;
            return this;
        }

        public Builder permissions(List<Permission> val) {
            permissions = val;
            return this;
        }

        public Builder logmsg(String val) {
            logmsg = val;
            return this;
        }

        public VerifyResult build() {
            return new VerifyResult(this);
        }
    }
}

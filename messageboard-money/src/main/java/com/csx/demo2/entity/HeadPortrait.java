package com.csx.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeadPortrait {
    private Integer id;
    private Integer user_id;
    private String image_url;

    private HeadPortrait(Builder builder) {
        setId(builder.id);
        setUser_id(builder.user_id);
        setImage_url(builder.image_url);
    }


    public static final class Builder {
        private Integer id;
        private Integer user_id;
        private String image_url;

        public Builder() {
        }

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder user_id(Integer val) {
            user_id = val;
            return this;
        }

        public Builder image_url(String val) {
            image_url = val;
            return this;
        }

        public HeadPortrait build() {
            return new HeadPortrait(this);
        }
    }
}

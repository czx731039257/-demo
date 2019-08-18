package com.csx.demo2.entity;

public class HeadPortrait {
    private Integer id;
    private Integer user_id;
    private String image_url;

    public HeadPortrait(Integer id, Integer user_id, String image_url) {
        this.id = id;
        this.user_id = user_id;
        this.image_url = image_url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "HeadPortrait{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}

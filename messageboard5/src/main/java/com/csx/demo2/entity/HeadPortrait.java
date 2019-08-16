package com.csx.demo2.entity;

public class HeadPortrait {
    private Integer id;
    private Integer user_id;
    private String image;

    public HeadPortrait(Integer id, Integer user_id, String image) {
        this.id = id;
        this.user_id = user_id;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "HeadPortrait{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", image='" + image + '\'' +
                '}';
    }
}

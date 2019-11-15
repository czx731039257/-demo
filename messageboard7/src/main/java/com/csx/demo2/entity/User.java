package com.csx.demo2.entity;

import java.util.List;

public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private Integer group_id;
    private List<Role> roles;
    private List<Message> messages;
    private Integer count_message;
    private Integer headportrait_id;
    private HeadPortrait currentHeadPortrait;
    private List<HeadPortrait> headPortraits;
    private Integer money;

    public User() {
    }

    public User(Integer id, String name, String password, String email, String phone, Integer group_id, Integer headportrait_id, Integer money) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.group_id = group_id;
        this.headportrait_id = headportrait_id;
        this.money = money;
    }

    public User(Integer id, String name, String password, String email, String phone, Integer group_id, Integer headportrait_id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.group_id = group_id;
        this.headportrait_id = headportrait_id;
    }

    public User(Integer id, String name, String password, String email, String phone, Integer group_id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.group_id = group_id;
    }

    public User(String name, Integer group_id) {
        this.name = name;
        this.group_id = group_id;
    }

    public User(Integer id, String name, String password, String email, String phone, Integer group_id, List<Role> roles, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
        this.messages = messages;
        this.group_id = group_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getCount_message() {
        return count_message;
    }

    public void setCount_message(Integer count_message) {
        this.count_message = count_message;
    }

    public HeadPortrait getCurrentHeadPortrait() {
        return currentHeadPortrait;
    }

    public void setCurrentHeadPortrait(HeadPortrait currentHeadPortrait) {
        this.currentHeadPortrait = currentHeadPortrait;
    }

    public List<HeadPortrait> getHeadPortraits() {
        return headPortraits;
    }

    public void setHeadPortraits(List<HeadPortrait> headPortraits) {
        this.headPortraits = headPortraits;
    }

    public Integer getHeadportrait_id() {
        return headportrait_id;
    }

    public void setHeadportrait_id(Integer headportrait_id) {
        this.headportrait_id = headportrait_id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", group_id=" + group_id +
                ", roles=" + roles +
                ", messages=" + messages +
                ", count_message=" + count_message +
                ", headPortrait_id=" + headportrait_id +
                ", currentHeadPortrait=" + currentHeadPortrait +
                ", headPortraits=" + headPortraits +
                '}';
    }
}

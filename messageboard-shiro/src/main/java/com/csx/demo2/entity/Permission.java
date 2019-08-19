package com.csx.demo2.entity;

import java.util.List;

public class Permission {
    private Integer id;
    private String name;
    private List<Role> roles;

    public Permission() {
    }

    public Permission(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Permission(Integer id, String name, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.roles = roles;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}

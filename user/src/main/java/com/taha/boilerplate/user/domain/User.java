package com.taha.boilerplate.user.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    private int id;
    private String name;
    private List<Role> rolesList;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Role> rolesList) {
        this.rolesList = rolesList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.taha.boilerplate.auth.dto;

import javax.validation.constraints.NotNull;

public class User {
    @NotNull
    private String email;
    @NotNull
    private String password;

    private String role = "ADMIN";


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

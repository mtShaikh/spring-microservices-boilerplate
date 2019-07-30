package com.taha.boilerplate.auth.service;


import com.taha.boilerplate.auth.dto.User;

public interface SharedUserService {
    User login(String email);
}

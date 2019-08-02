package com.taha.boilerplate.user.service;

import com.taha.boilerplate.user.domain.User;
import com.taha.boilerplate.user.dto.SignIn;

public interface UserService {
    User login(SignIn signIn);
}

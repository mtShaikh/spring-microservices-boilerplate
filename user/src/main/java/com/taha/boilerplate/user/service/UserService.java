package com.taha.boilerplate.user.service;

import com.netpace.bgc.um.dto.SignIn;
import com.taha.boilerplate.user.domain.User;

public interface UserService {
    User login(SignIn signIn);
}

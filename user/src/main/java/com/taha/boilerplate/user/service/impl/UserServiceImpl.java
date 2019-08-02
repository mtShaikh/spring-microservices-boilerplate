package com.taha.boilerplate.user.service.impl;

import com.taha.boilerplate.user.domain.User;
import com.taha.boilerplate.user.dto.SignIn;
import com.taha.boilerplate.user.exception.IncorrectEmailOrPasswordException;
import com.taha.boilerplate.user.repository.UserRepository;
import com.taha.boilerplate.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User login(SignIn signIn) {

        User user = userRepository.findByEmail(signIn.getEmail());

        if (user != null) {
            if (user.getEmail().equals(signIn.getEmail()) &&
                    bCryptPasswordEncoder.matches(signIn.getPassword(), user.getPassword())) {
                return user;
            }
        }
        throw new IncorrectEmailOrPasswordException();

    }
}

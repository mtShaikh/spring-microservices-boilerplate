package com.taha.boilerplate.auth.service.impl;

import com.taha.boilerplate.auth.dto.User;
import com.taha.boilerplate.auth.proxy.UserManagementClient;
import com.taha.boilerplate.auth.service.SharedUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SharedUserServiceImpl implements SharedUserService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserManagementClient userManagementClient;

    @Override
    public User login(String email) {
        try{
            return userManagementClient.login(email).getData();
        }catch(Exception e){
            log.info(e.toString());
            return null;
        }
    }
}

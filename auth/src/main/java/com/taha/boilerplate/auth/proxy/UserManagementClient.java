package com.taha.boilerplate.auth.proxy;


import com.taha.boilerplate.auth.dto.ServiceResponse;
import com.taha.boilerplate.auth.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="user-management-service")
public interface UserManagementClient {
    @GetMapping(value="/user/business/login")
    ServiceResponse<User> login(@RequestParam("email") String email);

}
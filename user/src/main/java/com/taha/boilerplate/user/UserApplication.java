package com.taha.boilerplate.user;

import com.taha.boilerplate.user.domain.Role;
import com.taha.boilerplate.user.domain.User;
import com.taha.boilerplate.user.repository.RoleRepository;
import com.taha.boilerplate.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Component
    class UserInitializer implements CommandLineRunner {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private RoleRepository roleRepository;

        @Override
        public void run(String... args) throws Exception {
            // setting up roles
            Role admin = new Role();
            admin.setName("ADMIN");

            Role user = new Role();
            user.setName("USER");

            //persisting roles
            roleRepository.saveAll(Stream.of(admin, user).collect(Collectors.toList()));

            // setting up users
            User foo = new User();
            foo.setEmail("foo@gmail.com");
            foo.setName("foo");
            foo.setPassword(passwordEncoder().encode("12345"));
            foo.setRoles(Stream.of(user).collect(Collectors.toSet()));

            User adminUser = new User();
            adminUser.setEmail("admin@gmail.com");
            adminUser.setName("admin");
            adminUser.setPassword(passwordEncoder().encode("12345"));
            adminUser.setRoles(Stream.of(admin, user).collect(Collectors.toSet()));

            //persisting users
            userRepository.saveAll(Stream.of(adminUser, foo).collect(Collectors.toList()));

            userRepository.findAll().forEach(System.out::println);
        }

    }

}

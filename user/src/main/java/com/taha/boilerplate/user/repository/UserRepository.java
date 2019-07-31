package com.taha.boilerplate.user.repository;

import com.taha.boilerplate.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

        User findByEmail(String email);
}

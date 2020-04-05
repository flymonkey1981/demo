package com.example.demo.repository;

import com.example.demo.data.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLastName(String lastName);
    Optional<User> findByUserName(String userName);
    Optional<User> findByUserNameAndHashPassword(String userName, String hashpassword);
}

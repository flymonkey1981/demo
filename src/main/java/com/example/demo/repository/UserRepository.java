package com.example.demo.repository;

import com.example.demo.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLastName(String lastName);
}

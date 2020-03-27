package com.example.demo.dao;

import com.example.demo.data.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User insertUser(User user);
    List<User> listUser();
    User updateUser(Long id, User user);
    Optional<User> selectUserById(Long id);

    Optional<User> findByUserNameAndHashPassword(String userName, String hashPassword);
}

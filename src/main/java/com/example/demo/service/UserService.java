package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(@Qualifier("userMySQLDB") UserDao userDao){
        this.userDao = userDao;
    }

    public User insertUser(User user) {
       return userDao.insertUser(user);
    }

    public Optional<User> selectUserById(Long id) {
        return userDao.selectUserById(id);
    }

    public User updateUser(Long id, User user) {
       return userDao.updateUser(id, user);
    }

    public List<User> listUsers() {
        return userDao.listUser();
    }

    public Optional<User> findByUserNameAndHashPassword(String userName, String hashPassword) {
           return userDao.findByUserNameAndHashPassword(userName, hashPassword);
    }

    public Optional<User> findByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    
}

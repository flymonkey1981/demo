package com.example.demo.dao;

import com.example.demo.data.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository("userMySQLDB")
public class UserDaoImpl implements UserDao{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listUser() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public User updateUser(Long id, User user) {
        return selectUserById(id).map(
                u -> {
                    u.setUserName(u.getUserName());
                    u.setLastName(u.getLastName());
                    return userRepository.save(u);
                }).orElseGet(() -> {
            user.setId(id);
            return userRepository.save(user);
        });

    }

    @Override
    public Optional<User> selectUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUserNameAndHashPassword(String userName, String hashPassword) {
        return userRepository.findByUserNameAndHashPassword(userName, hashPassword);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


}

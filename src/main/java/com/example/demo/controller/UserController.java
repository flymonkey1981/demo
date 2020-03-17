package com.example.demo.controller;

import com.example.demo.data.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/user", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    void createUser(@RequestBody User user) {
        userService.insertUser(user);

    }

    @GetMapping(path="{id}")
    User getUserById(@PathVariable("id") Long id){
        return userService.selectUserById(id).orElse(null);

    }

    @GetMapping
    List<User> listUsers() {
        return userService.listUsers();
    }

    @PutMapping(path="{id}")
    void updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }
}

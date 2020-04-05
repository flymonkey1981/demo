package com.example.demo.controller;

import com.example.demo.data.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value="api/v1/user", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    User createUser(@RequestBody User user) {
       return userService.insertUser(user);

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

    @RequestMapping(value="/login", method = GET)
    ResponseEntity<?> login(@RequestParam("username") String username, @RequestParam ("hashpassword") String hashpassword) {
        Optional<User> group =userService.findByUserNameAndHashPassword(username, hashpassword);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }

    @RequestMapping(value="/isUserNameUnique", method = GET)
    ResponseEntity<?> login(@RequestParam("username") String username) {
        Optional<User> group =userService.findByUserName(username);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }


}

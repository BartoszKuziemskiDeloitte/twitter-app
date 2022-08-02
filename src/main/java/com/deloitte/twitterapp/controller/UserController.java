package com.deloitte.twitterapp.controller;

import com.deloitte.twitterapp.model.User;
import com.deloitte.twitterapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable final Long id) {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

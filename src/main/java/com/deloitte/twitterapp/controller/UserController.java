package com.deloitte.twitterapp.controller;

import com.deloitte.twitterapp.model.User;
import com.deloitte.twitterapp.service.UserService;
import com.deloitte.twitterapp.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final PostServiceImpl postService;

    @Autowired
    public UserController(UserService userService, PostServiceImpl postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody final User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable final Long id) {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }






    /**
     * nie usuwać, zapytać gdzie lepiej mieć metodę createPost
     */
//    @PostMapping("/{id}")
//    public ResponseEntity<Post> createPost(@RequestBody final Post post, @PathVariable final Long id) {
//        Post postToAdd = post;
//        User user = userService.getUser(id);
//        postToAdd.setUser(user);
//        return new ResponseEntity<>(postService.addPost(postToAdd), HttpStatus.OK);
//    }

}

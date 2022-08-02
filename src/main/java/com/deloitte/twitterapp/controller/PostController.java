package com.deloitte.twitterapp.controller;

import com.deloitte.twitterapp.model.Post;
import com.deloitte.twitterapp.model.User;
import com.deloitte.twitterapp.service.UserService;
import com.deloitte.twitterapp.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = postService.getPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping("/users/{id}")
    public ResponseEntity<Post> createPost(@RequestBody final Post post, @PathVariable final Long id) {
        Post postToAdd = post;
        User user = userService.getUser(id);
        postToAdd.setUser(user);
        return new ResponseEntity<>(postService.addPost(postToAdd), HttpStatus.OK);
    }

}

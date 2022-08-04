package com.deloitte.twitterapp.controller;

import com.deloitte.twitterapp.model.Post;
import com.deloitte.twitterapp.model.User;
import com.deloitte.twitterapp.service.PostService;
import com.deloitte.twitterapp.service.UserService;
import com.deloitte.twitterapp.service.impl.PostServiceImpl;
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
    public PostController(PostServiceImpl postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<Post> createPost(@RequestBody final Post post, @PathVariable final Long userId) {
        Post postToAdd = post;
        User user = userService.getUser(userId);
        postToAdd.setUser(user);
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable final Long id) {
        return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> editPost(@PathVariable final Long id, @RequestBody Post post) {
        return new ResponseEntity<>(postService.editPost(post, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable final Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>( "Post deleted successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = postService.getPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/{id}/user/{userId}")
    public ResponseEntity<Post> addLike(@PathVariable final Long id, @PathVariable final Long userId) {
        // TODO: 04.08.2022  
        return null;
    }



}

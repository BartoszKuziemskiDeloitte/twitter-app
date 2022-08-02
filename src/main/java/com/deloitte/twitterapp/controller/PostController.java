package com.deloitte.twitterapp.controller;

import com.deloitte.twitterapp.model.Post;
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

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = postService.getPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Post> addPost(@RequestBody final Post post) {
//        return new ResponseEntity<>(postService.addPost(post), HttpStatus.OK);
//    }

}

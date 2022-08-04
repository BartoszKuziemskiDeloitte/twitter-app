package com.deloitte.twitterapp.controller;

import com.deloitte.twitterapp.model.Comment;
import com.deloitte.twitterapp.model.Post;
import com.deloitte.twitterapp.repository.CommentRepository;
import com.deloitte.twitterapp.service.CommentService;
import com.deloitte.twitterapp.service.PostService;
import com.deloitte.twitterapp.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//TODO
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final PostService postService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService, CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
        this.commentService = commentService;
        this.postService = postService;
    }
    @GetMapping
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> comments = commentService.getComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    @PostMapping("/id")
    public ResponseEntity<Comment> createComment(@RequestBody final Comment comment, @PathVariable final Long postId) {
        Comment addedComment = comment;
        Post post = postService.getPost(postId);
        addedComment.setPost(post);
        return new ResponseEntity<>(commentService.createComment(addedComment), HttpStatus.OK);
    }

}

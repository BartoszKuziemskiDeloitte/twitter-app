package com.deloitte.twitterapp.controller;

import com.deloitte.twitterapp.model.Comment;
import com.deloitte.twitterapp.model.Post;
import com.deloitte.twitterapp.model.User;
import com.deloitte.twitterapp.repository.CommentRepository;
import com.deloitte.twitterapp.service.CommentService;
import com.deloitte.twitterapp.service.PostService;
import com.deloitte.twitterapp.service.UserService;
import com.deloitte.twitterapp.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;
    private final UserService userService;

    @Autowired
    public CommentController(CommentService commentService, PostService postService, UserService userService) {
        this.commentService = commentService;
        this.postService = postService;
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> comments = commentService.getComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    @PostMapping("/{userId}/{id}")
    public ResponseEntity<Comment> createComment(@RequestBody final Comment comment, @PathVariable final long userId, @PathVariable final Long id) {
        Comment addedComment = comment;
        User postAuthorId = userService.getUser(userId);
        Post post = postService.getPost(id);
        addedComment.setPost(post);
        addedComment.setUser(postAuthorId);
        return new ResponseEntity<>(commentService.createComment(addedComment), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable final Long id, @RequestBody final Comment comment) {
        Comment editedComment = commentService.getComment(id);
        editedComment.setContent(comment.getContent());
        return new ResponseEntity<>(commentService.editComment(editedComment), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable final Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>( "Comment deleted successfully", HttpStatus.OK);
    }
}


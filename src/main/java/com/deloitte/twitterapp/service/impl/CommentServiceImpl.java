package com.deloitte.twitterapp.service.impl;

import com.deloitte.twitterapp.model.Comment;
import com.deloitte.twitterapp.model.Post;
import com.deloitte.twitterapp.repository.CommentRepository;
import com.deloitte.twitterapp.service.CommentService;
import com.deloitte.twitterapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }
    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Comment editComment(Comment comment, Long commentId) {
        Comment editedComment = getComment(commentId);
        editedComment.setContent(comment.getContent());
        return commentRepository.save(editedComment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment createComment(Comment comment) { return comment; }


}

package com.deloitte.twitterapp.service;

import com.deloitte.twitterapp.model.Comment;

import java.util.List;

public interface CommentService {
    Comment getComment(Long commentId);
    Comment editComment(Comment comment);
    void deleteComment(Long commentId);
    List<Comment> getComments();

    Comment createComment(Comment comment);
}

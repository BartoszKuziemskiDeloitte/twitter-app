package com.deloitte.twitterapp.model;

import com.deloitte.twitterapp.interfaces.IPost;

import java.util.List;

public class Post implements IPost {
    private Long id;
    private User user;
    private String content;
    private List<Comment> comments;

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void deleteComment(Comment comment) {

    }

    public Post(User user, String content) {
        this.user = user;
        this.content = content;
    }

}

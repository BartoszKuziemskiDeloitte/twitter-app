package com.deloitte.twitterapp.interfaces;

import com.deloitte.twitterapp.model.Comment;

public interface IPost {
    void addComment(Comment comment);
    void deleteComment(Comment comment);
}

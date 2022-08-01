package com.deloitte.twitterapp.interfaces;

import com.deloitte.twitterapp.model.Post;

public interface IMainPage {
    void addPost(Post post);
    void deletePost(Post post);
    void printPosts();
}

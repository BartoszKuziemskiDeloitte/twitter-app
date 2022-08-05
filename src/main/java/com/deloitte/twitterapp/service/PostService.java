package com.deloitte.twitterapp.service;

import com.deloitte.twitterapp.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post getPost(Long id);
    Post editPost(Post post, Long id);
    void deletePost(Long id);
    List<Post> getPosts();
    List<Post> getAllUserPosts(Long userId);
}

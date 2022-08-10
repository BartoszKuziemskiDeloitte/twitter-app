package com.deloitte.twitterapp.service;

import com.deloitte.twitterapp.mapper.dto.PostDto;
import com.deloitte.twitterapp.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(PostDto post, Long userId);
    PostDto getPostDto(Long id);
    Post getPost(Long id);
    Post editPost(Post post, Long id);
    void deletePost(Long id);
    List<Post> getPosts();
    List<PostDto> getAllUserPosts(Long userId);
}

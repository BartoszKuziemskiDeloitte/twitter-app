package com.deloitte.twitterapp.service.impl;

import com.deloitte.twitterapp.mapper.SimpleMapper;
import com.deloitte.twitterapp.mapper.dto.PostDto;
import com.deloitte.twitterapp.model.Post;
import com.deloitte.twitterapp.model.User;
import com.deloitte.twitterapp.repository.PostRepository;
import com.deloitte.twitterapp.service.PostService;
import com.deloitte.twitterapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final SimpleMapper simpleMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserService userService, SimpleMapper simpleMapper){
        this.postRepository = postRepository;
        this.userService = userService;
        this.simpleMapper = simpleMapper;
    }

    @Override
    public Post createPost(PostDto postDto, Long userId) {
        User user = userService.getUser(userId);
        Post post = simpleMapper.postDtoToPost(postDto);
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public PostDto getPostDto(Long id) {
        Post post = postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return simpleMapper.postToPostDto(post);
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Post editPost(Post post, Long id) {
        Post postToEdit = getPost(id);
        postToEdit.setContent(post.getContent());
        return postRepository.save(postToEdit);
    }

    @Override
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    @Override
    public List<PostDto> getAllUserPosts(Long userId) {
        List<Post> posts = postRepository.findAllByUser_Id(userId);
        return simpleMapper.postListToPostDtoList(posts);
    }

    // move to comment service
//    public Comment addCommentToPost(Long postId, Long commentId) {
//        Post post = postRepository.getReferenceById(postId);
//        Comment comment = commentRepository.getReferenceById(commentId);
//        post.addComment(comment);
//        comment.setPost(post);
//        return comment;
//    }

}

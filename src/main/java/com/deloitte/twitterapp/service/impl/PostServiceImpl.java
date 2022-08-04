package com.deloitte.twitterapp.service.impl;

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

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserService userService){
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
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

    // move to comment service
//    public Comment addCommentToPost(Long postId, Long commentId) {
//        Post post = postRepository.getReferenceById(postId);
//        Comment comment = commentRepository.getReferenceById(commentId);
//        post.addComment(comment);
//        comment.setPost(post);
//        return comment;
//    }

}

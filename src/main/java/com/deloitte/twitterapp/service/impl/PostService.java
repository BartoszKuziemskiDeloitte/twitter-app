package com.deloitte.twitterapp.service.impl;

import com.deloitte.twitterapp.model.Comment;
import com.deloitte.twitterapp.model.Post;
import com.deloitte.twitterapp.repository.CommentRepository;
import com.deloitte.twitterapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository){
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public Comment addCommentToPost(Long postId, Long commentId) {
        Post post = postRepository.getReferenceById(postId);
        Comment comment = commentRepository.getReferenceById(commentId);
        post.addComment(comment);
        comment.setPost(post);
        return comment;
    }


}

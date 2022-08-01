package com.deloitte.twitterapp.model;

import com.deloitte.twitterapp.interfaces.IPost;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post implements IPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;
    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Post() {}

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

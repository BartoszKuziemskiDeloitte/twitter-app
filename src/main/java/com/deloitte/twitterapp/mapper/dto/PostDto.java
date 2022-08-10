package com.deloitte.twitterapp.mapper.dto;

import com.deloitte.twitterapp.model.Comment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostDto {
    private String content;
    private List<Comment> comments;
}

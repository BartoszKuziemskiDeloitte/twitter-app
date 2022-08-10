package com.deloitte.twitterapp.mapper;

import com.deloitte.twitterapp.mapper.dto.PostDto;
import com.deloitte.twitterapp.mapper.dto.UserDto;
import com.deloitte.twitterapp.model.Post;
import com.deloitte.twitterapp.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SimpleMapper {
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    List<UserDto> userListToUserDtoList(List<User> users);

    PostDto postToPostDto(Post post);

    Post postDtoToPost(PostDto postDto);

    List<PostDto> postListToPostDtoList(List<Post> posts);

}

package com.deloitte.twitterapp.service;

import com.deloitte.twitterapp.mapper.dto.UserDto;
import com.deloitte.twitterapp.model.User;

import java.util.List;

public interface UserService {

    User addUser(UserDto user);

    void deleteUser(Long id);

    List<UserDto> getUsers();

    UserDto getUserDto(Long id);

    User getUser(Long id);
}

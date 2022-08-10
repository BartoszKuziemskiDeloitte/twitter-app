package com.deloitte.twitterapp.service.impl;

import com.deloitte.twitterapp.mapper.SimpleMapper;
import com.deloitte.twitterapp.mapper.dto.UserDto;
import com.deloitte.twitterapp.model.User;
import com.deloitte.twitterapp.repository.PostRepository;
import com.deloitte.twitterapp.repository.UserRepository;
import com.deloitte.twitterapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SimpleMapper simpleMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PostRepository postRepository, SimpleMapper simpleMapper) {
        this.userRepository = userRepository;
        this.simpleMapper = simpleMapper;
    }

    public User addUser(UserDto userDto) {
        User user = simpleMapper.userDtoToUser(userDto);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        return simpleMapper.userListToUserDtoList(users);
    }

    public UserDto getUserDto(Long id) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return simpleMapper.userToUserDto(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
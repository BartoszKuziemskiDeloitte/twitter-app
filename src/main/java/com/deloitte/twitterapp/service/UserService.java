package com.deloitte.twitterapp.service;

import com.deloitte.twitterapp.model.User;
import com.deloitte.twitterapp.repository.PostRepository;
import com.deloitte.twitterapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository, PostRepository postRepository) {
       this.userRepository = userRepository;
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
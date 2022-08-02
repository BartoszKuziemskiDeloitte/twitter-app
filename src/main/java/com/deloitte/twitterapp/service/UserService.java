package com.deloitte.twitterapp.service;

import com.deloitte.twitterapp.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    void deleteUser(Long id);

    List<User> getUsers();

    User getUser(Long id);
}

package com.userservice.service;

import com.userservice.entity.Rating;
import com.userservice.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAll();

    User getById(Long id);

}

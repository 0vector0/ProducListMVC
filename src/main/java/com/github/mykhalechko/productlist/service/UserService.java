package com.github.mykhalechko.productlist.service;


import com.github.mykhalechko.productlist.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    User findById(Long id);
}

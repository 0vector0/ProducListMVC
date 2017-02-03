package com.github.mykhalechko.productlist.service;


import com.github.mykhalechko.productlist.entity.User;

public interface UserService {
    void edit(User user);

    void save(User user);

    User findByUsername(String username);

    User findById(Long id);

    public User getAuthenticationUser();

    User findByEmail(String email);
}

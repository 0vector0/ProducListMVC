package com.github.mykhalechko.productlist.dao;

import com.github.mykhalechko.productlist.entity.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserDao extends Repository<User, Long> {

    Optional<User> findByUsername(String username);

    void save(User user);
}

package com.github.mykhalechko.productlist.repository;

import com.github.mykhalechko.productlist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

package com.github.mykhalechko.productlist.repository;

import com.github.mykhalechko.productlist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUsername(String username);

}

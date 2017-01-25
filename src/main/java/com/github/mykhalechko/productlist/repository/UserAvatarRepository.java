package com.github.mykhalechko.productlist.repository;

import com.github.mykhalechko.productlist.model.UserAvatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserAvatarRepository extends JpaRepository<UserAvatar, Long> {

    @Query("select a from UserAvatar a where a.userId = :user_id")
    UserAvatar findUserAvatarByUserId(@Param("user_id") Long id);
}


package com.github.mykhalechko.productlist.repository;

import com.github.mykhalechko.productlist.entity.UserAvatar;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAvatarRepository extends JpaRepository<UserAvatar, Long> {

//    @Query("select a from UserAvatar a where a.userId = :user_id")
//    UserAvatar findByUserId(@Param("user_id") Long id);
}


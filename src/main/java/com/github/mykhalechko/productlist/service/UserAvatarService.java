package com.github.mykhalechko.productlist.service;

import com.github.mykhalechko.productlist.model.UserAvatar;

import java.util.List;

public interface UserAvatarService {

    List<UserAvatar> findAll();

    UserAvatar findByUserId(Long id);

    UserAvatar findById(Long id);

    UserAvatar save(UserAvatar userAvatar);

    void deleteById(Long id);

    UserAvatar edit(UserAvatar product);
}

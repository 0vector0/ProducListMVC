package com.github.mykhalechko.productlist.service;

import com.github.mykhalechko.productlist.model.UserAvatar;
import com.github.mykhalechko.productlist.repository.UserAvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserAvatarServiceImpl implements UserAvatarService {

    @Autowired
    private UserAvatarRepository userAvatarRepository;

    @Transactional
    @Override
    public List<UserAvatar> findAll() {

        return userAvatarRepository.findAll();
    }

    @Transactional
    @Override
    public UserAvatar findById(Long id) {
        return userAvatarRepository.findOne(id);
    }

    @Transactional
    @Override
    public UserAvatar save(UserAvatar userAvatar) {
        return userAvatarRepository.saveAndFlush(userAvatar);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userAvatarRepository.delete(id);
    }

    @Override
    public UserAvatar edit(UserAvatar product) {
        return userAvatarRepository.saveAndFlush(product);
    }
}



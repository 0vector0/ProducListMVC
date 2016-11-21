package com.github.mykhalechko.productlist.service;

import com.github.mykhalechko.productlist.entity.User;
import com.github.mykhalechko.productlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean createUser(User user) {

        try {
            // TODO: 21.11.2016 remove System and printStackTrace
            System.out.println(user);
            userRepository.saveAndFlush(user);
            return true;

        } catch (JpaSystemException e) {
            e.printStackTrace();
            return false;
        }
    }
}

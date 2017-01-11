package com.github.mykhalechko.productlist.service;

import com.github.mykhalechko.productlist.entity.User;
import com.github.mykhalechko.productlist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private RoleDao roleDao;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;


//    public void save(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        Set<Role> roles = new HashSet<>();
//        roles.add(roleDao.getOne(1L));
//        user.setRoles(roles);
//        userDao.save(user);
//    }

//    public User findByUsername(String username) {
//        return userDao.findByUsername(username);
//    }

    public Optional<User> getUserByUserName(String username) {
        return userRepository.findOneByUsername(username);
    }
}
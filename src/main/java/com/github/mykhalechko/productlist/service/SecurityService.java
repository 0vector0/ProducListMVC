package com.github.mykhalechko.productlist.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);
}
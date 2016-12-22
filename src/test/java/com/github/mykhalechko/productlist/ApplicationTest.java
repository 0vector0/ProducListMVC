package com.github.mykhalechko.productlist;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ApplicationTest {
    @Test
    public void main() throws Exception {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

}
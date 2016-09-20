package com.github.mykhalechko.productlistmvc.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<Product>();
}

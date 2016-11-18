package com.github.mykhalechko.productlist.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
//    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
//    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "username")
    private String name;
    @Column(name = "password")
    private String password;
    @Transient
    private String confirmPassword;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<Product>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
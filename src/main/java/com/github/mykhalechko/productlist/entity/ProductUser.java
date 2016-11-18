package com.github.mykhalechko.productlist.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "puser")
public class ProductUser {

    @Id
    @Column(name = "puser_id")
//    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
//    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productUserId;
    @Column(name = "pusername")
    private String productUsername;
    @Column(name = "ppassword")
    private String productPassword;
    @Transient
    private String productConfirmPassword;

    //    @OneToMany(mappedBy = "product_user", fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<Product>();

    public int getProductUserId() {
        return productUserId;
    }

    public void setProductUserId(int productUserId) {
        this.productUserId = productUserId;
    }

    public String getProductUsername() {
        return productUsername;
    }

    public void setProductUsername(String productUsername) {
        this.productUsername = productUsername;
    }

    public String getProductPassword() {
        return productPassword;
    }

    public void setProductPassword(String productPassword) {
        this.productPassword = productPassword;
    }

    public String getProductConfirmPassword() {
        return productConfirmPassword;
    }

    public void setProductConfirmPassword(String productConfirmPassword) {
        this.productConfirmPassword = productConfirmPassword;
    }

//    public Set<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
}

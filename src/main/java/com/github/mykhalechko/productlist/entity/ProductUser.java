//package com.github.mykhalechko.productlist.entity;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "productuser")
//public class ProductUser {
//
//    @Id
//    @Column(name = "productuserid", nullable = false)
////    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
////    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int productUserId;
//    @Column(name = "productusername")
//    private String productUserName;
//    @Column(name = "productuserpassword")
//    private String productUserPassword;
//    //    @Transient
////    private String productUserConfirmPassword;
//
//    //    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productuser")
//    private List<Product> products = new ArrayList<>();
//
//    public String getProductUserName() {
//        return productUserName;
//    }
//
//    public void setProductUserName(String productUserName) {
//        this.productUserName = productUserName;
//    }
//
//    public String getProductUserPassword() {
//        return productUserPassword;
//    }
//
//    public void setProductUserPassword(String productUserPassword) {
//        this.productUserPassword = productUserPassword;
//    }
//
//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }
//
//    public int getProductUserId() {
//        return productUserId;
//    }
//
//    public void setProductUserId(int productUserId) {
//        this.productUserId = productUserId;
//    }
//
//
//}

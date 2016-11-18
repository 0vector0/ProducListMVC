package com.github.mykhalechko.productlist.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product implements Serializable {


    private static final long serialVersionUID = -9014999225309767509L;
    @Id
    @Column(name = "product_id")
//    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1)
//    @GeneratedValue(generator = "product_id_seq", strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_price")
    private BigDecimal productPrice;

    @ManyToOne(fetch = FetchType.LAZY/*, cascade = CascadeType.ALL*/)
    @JoinColumn(name = "products")
    private ProductUser productUser;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

//    public ProductUser getProductUser() {
//        return productUser;
//    }
//
//    public void setProductUser(ProductUser productUser) {
//        this.productUser = productUser;
//    }
}

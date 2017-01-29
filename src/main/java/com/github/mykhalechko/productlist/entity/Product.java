package com.github.mykhalechko.productlist.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product implements Serializable {


    private static final long serialVersionUID = -9014999225309767509L;

    @Id
    @Column(name = "product_id")
//    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1)
//    @GeneratedValue(generator = "product_id_seq", strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "product_name", nullable = false)
    private String name;
    @Column(name = "product_description", nullable = false)
    private String description;
    @Column(name = "product_price")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", user=" + user.getUsername() +
                '}';
    }
}
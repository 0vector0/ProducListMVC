package com.github.mykhalechko.productlist.repository;

import com.github.mykhalechko.productlist.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}

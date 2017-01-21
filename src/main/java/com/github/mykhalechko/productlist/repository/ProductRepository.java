package com.github.mykhalechko.productlist.repository;

import com.github.mykhalechko.productlist.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.user.id = :user_id")
    List<Product> findAllUserProducts(@Param("user_id") Long id);
}

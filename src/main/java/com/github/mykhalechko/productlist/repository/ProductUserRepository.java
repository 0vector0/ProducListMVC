package com.github.mykhalechko.productlist.repository;

import com.github.mykhalechko.productlist.entity.ProductUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductUserRepository extends JpaRepository<ProductUser, Long> {
}

package com.github.mykhalechko.productlist.repository;

import com.github.mykhalechko.productlist.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long> {
}

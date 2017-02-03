package com.github.mykhalechko.productlist.service;

import com.github.mykhalechko.productlist.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> findAll();

    CategoryEntity findById(Long id);

    CategoryEntity create(CategoryEntity categoryEntity);

    CategoryEntity edit(CategoryEntity categoryEntity);

    void deleteById(Long id);
}

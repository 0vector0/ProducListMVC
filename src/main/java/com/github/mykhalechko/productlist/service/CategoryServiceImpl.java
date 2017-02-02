package com.github.mykhalechko.productlist.service;

import com.github.mykhalechko.productlist.entity.CategoryEntity;
import com.github.mykhalechko.productlist.repository.CategoryEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryEntityRepository categoryEntityRepository;


    @Override
    public List<CategoryEntity> findAll() {
        return categoryEntityRepository.findAll();
    }

    @Override
    public CategoryEntity findById(Long id) {
        return categoryEntityRepository.findOne(id);
    }

    @Override
    public CategoryEntity create(CategoryEntity categoryEntity) {
        return categoryEntityRepository.saveAndFlush(categoryEntity);
    }

    @Override
    public CategoryEntity edit(CategoryEntity categoryEntity) {
        return categoryEntityRepository.saveAndFlush(categoryEntity);
    }

    @Override
    public void deleteById(Long id) {
        categoryEntityRepository.delete(id);

    }
}

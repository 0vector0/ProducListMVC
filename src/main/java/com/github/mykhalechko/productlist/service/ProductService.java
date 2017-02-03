package com.github.mykhalechko.productlist.service;


import com.github.mykhalechko.productlist.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    List<Product> findAllUserProducts(Long id);

    Product findById(Long id);

    Product create(Product product);

    Product edit(Product product);

    void deleteById(Long id);

}



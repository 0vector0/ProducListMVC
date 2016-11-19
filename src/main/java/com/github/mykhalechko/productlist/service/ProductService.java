package com.github.mykhalechko.productlist.service;


import com.github.mykhalechko.productlist.entity.Product;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);

    public void updateProduct(Product product);

    public void removeProduct(long id);

    public Product getProductById(long id);

    public List<Product> listProducts();
}

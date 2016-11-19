package com.github.mykhalechko.productlist.service;

import com.github.mykhalechko.productlist.dao.ProductDao;
import com.github.mykhalechko.productlist.entity.Product;
import com.github.mykhalechko.productlist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductRepository productRepository;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void addProduct(Product product) {
        this.productDao.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        this.productDao.updateProduct(product);
    }

    @Override
    public void removeProduct(long id) {
        this.productDao.removeProduct(id);
    }

    @Override
    public Product getProductById(long id) {
        return this.productDao.getProductById(id);
    }

    @Override
    public List<Product> listProducts() {
        List<Product> products = productRepository.findAll();
        Collections.sort(products, Product.ProductNameComparator);
        return products;
    }
}

package com.github.mykhalechko.productlist.service;

import com.github.mykhalechko.productlist.dao.ProductDao;
import com.github.mykhalechko.productlist.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

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
    public void removeProduct(int id) {
        this.productDao.removeProduct(id);
    }

    @Override
    public Product getProductById(int id) {
        return this.productDao.getProductById(id);
    }

    @Override
    public List<Product> listProducts() {
        return this.productDao.listProducts();
    }
}

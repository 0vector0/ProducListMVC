package com.github.mykhalechko.productlist.service;

import com.github.mykhalechko.productlist.entity.Product;
import com.github.mykhalechko.productlist.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
// TODO: 21.01.2017 separate method
        List<Product> products = productRepository.findAll();
        sortProducts(products);
        return products;
    }

    private void sortProducts(List<Product> products) {
        // TODO: 21.01.2017 use java8 
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                String ProductName1 = p1.getName().toUpperCase();
                String ProductName2 = p2.getName().toUpperCase();

                //ascending order
                return ProductName1.compareTo(ProductName2);

                //descending order
                //return ProductName2.compareTo(ProductName1);
            }
        });
    }

    @Override
    public List<Product> findAllUserProducts(Long id) {

        List<Product> products = productRepository.findAllUserProducts(id);
        sortProducts(products);
        return products;

    }


    @Override
    public Product findById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product create(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product edit(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.delete(id);
    }
}

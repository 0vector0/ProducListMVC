package com.github.mykhalechko.productlist.dao;

import com.github.mykhalechko.productlist.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    @Transactional
    public void removeProduct(long id) {
        Product product = getProductById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public Product getProductById(long id) {
        return entityManager.find(Product.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Product> listProducts() {
        List<Product> products = entityManager.createQuery("FROM Product", Product.class).getResultList();
//        Collections.sort(products, Product.ProductNameComparator);
        return products;
    }
}

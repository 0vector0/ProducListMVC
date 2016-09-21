package com.github.mykhalechko.productlist.dao;

import com.github.mykhalechko.productlist.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private EntityManager entityManager;

    @PersistenceContext(unitName = "ProductManagement", type = PersistenceContextType.EXTENDED)
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
    public void removeProduct(int id) {
        Product product = getProductById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    public Product getProductById(int id) {
        return entityManager.find(Product.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Product> listProducts() {
        List<Product> products = entityManager.createQuery("FROM Product", Product.class).getResultList();
        return products;
    }
}

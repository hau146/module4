package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> showAll() {
        TypedQuery<Product> productTypedQuery = (TypedQuery<Product>) entityManager.createNativeQuery("select*from product", Product.class);
        return productTypedQuery.getResultList();
    }

    @Transactional
    @Override
    public boolean create(Product product) {
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean update(Product product) {
        try {
            Product productEntity = finById(product.getId());
            productEntity.setId(product.getId());
            productEntity.setNameProduct(product.getNameProduct());
            productEntity.setPriceProduct(product.getPriceProduct());
            productEntity.setDescribeProduct(product.getDescribeProduct());
            productEntity.setProducer(product.getProducer());
            entityManager.merge(productEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Product finById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        try {
            Product product = finById(id);
            entityManager.remove(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

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
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    @Override
    public void update(Product product) {
        Product productEntity = finById(product.getId());
        productEntity.setId(product.getId());
        productEntity.setNameProduct(product.getNameProduct());
        productEntity.setPriceProduct(product.getPriceProduct());
        productEntity.setDescribeProduct(product.getDescribeProduct());
        productEntity.setProducer(product.getProducer());
        entityManager.merge(productEntity);
    }

    @Override
    public Product finById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Product product = finById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> searchByName(String nameProduct) {
        List<Product> products = new ArrayList<>();
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getNameProduct().contains(nameProduct)) {
//                products.add(productList.get(i));
//            }
//        }
        return products;
    }
}

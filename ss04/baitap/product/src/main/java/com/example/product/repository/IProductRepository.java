package com.example.product.repository;

import com.example.product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> showAll();
    void create(Product product);
    void update(Product product);
    Product finById(int id);
    void delete(int id);
    List<Product> searchByName(String nameProduct);
}

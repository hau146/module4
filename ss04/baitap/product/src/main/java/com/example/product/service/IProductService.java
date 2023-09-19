package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();
    void create(Product product);
    void update(Product product);
    Product finById(int id);
    void delete(int id);
    List<Product> searchByName(String nameProduct);
}

package com.example.product.service;

import com.example.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();
    boolean create(Product product);
    boolean update(Product product);
    Product finById(int id);
    boolean delete(int id);
}

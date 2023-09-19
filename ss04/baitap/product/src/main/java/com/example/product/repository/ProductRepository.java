package com.example.product.repository;

import com.example.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Áo", 25000, "còn hàng", "nike"));
        productList.add(new Product(2, "Quần", 30000, "mới nhập", "dior"));
        productList.add(new Product(3, "Mũ", 15000, "hết hàng", "TBG"));
    }

    @Override
    public List<Product> showAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Product product) {
        productList.set(product.getId() - 1, product);
    }

    @Override
    public Product finById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
       productList.remove(id-1);
    }

    @Override
    public List<Product> searchByName(String nameProduct) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getNameProduct().contains(nameProduct)) {
                products.add(productList.get(i));
            }
        }
        return products;
    }
}

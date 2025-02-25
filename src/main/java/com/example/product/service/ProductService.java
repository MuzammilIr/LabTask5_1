package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    private final List<Product> productsList = new ArrayList<>();

    public Product addProduct(Product product) {
        productsList.add(product);
        return product;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public Product getProduct(int id) {
        return productsList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Product updateProduct(int id, Product product) {
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId() == id) {
                productsList.set(i, product);
                return product;
            }
        }
        return null;
    }

    public boolean deleteProduct(int id) {
        return productsList.removeIf(product -> product.getId()==id);
    }
}
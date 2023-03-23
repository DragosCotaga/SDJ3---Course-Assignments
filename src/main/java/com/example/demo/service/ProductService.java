package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private final Map<Long, Product> products = new HashMap<>();
    private long nextId = 1;

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.put(product.getId(), product);
        return product;
    }

    public Product getProductById(Long id) {
        return products.get(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        products.put(id, product);
        return product;
    }

    public boolean deleteProduct(Long id) {
        return products.remove(id) != null;
    }
}

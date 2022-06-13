package com.example.demo.infrastructure.adapters.primary;

import com.example.demo.infrastructure.domain.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    void deleteProduct(int idToDelete);

    Product findProductById(int idToSearch);

    List<Product> getProducts();
}

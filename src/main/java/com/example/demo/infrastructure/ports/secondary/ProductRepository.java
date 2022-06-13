package com.example.demo.infrastructure.ports.secondary;

import com.example.demo.infrastructure.domain.Product;

import java.util.List;

public interface ProductRepository {
    Product addProduct(Product product);

    void deleteProduct(int idToDelete);

    Product findProductById(int idToSearch);

    List<Product> getProducts();
}

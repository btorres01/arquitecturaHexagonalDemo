package com.example.demo.infrastructure.adapters.primary;

import com.example.demo.infrastructure.domain.Product;
import com.example.demo.infrastructure.ports.secondary.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    @Override
    public void deleteProduct(int idToDelete) {
        productRepository.deleteProduct(idToDelete);
    }

    @Override
    public Product findProductById(int idToSearch) {
        return productRepository.findProductById(idToSearch);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}

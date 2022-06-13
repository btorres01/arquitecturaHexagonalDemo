package com.example.demo.infrastructure.adapters.secondary;

import com.example.demo.infrastructure.domain.Product;
import com.example.demo.infrastructure.ports.secondary.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryMySQLDatabase implements ProductRepository {

    public static List<Product> productList=new ArrayList<>();

    @Override
    public Product addProduct(Product product) {
        if(productList.add(product)){
            return product;
        }
        return null;
    }

    @Override
    public void deleteProduct(int idToDelete) {
    productList= productList.stream().filter(product -> product.getId() != idToDelete).collect(Collectors.toList());
    }

    @Override
    public Product findProductById(int idToSearch) {
        List<Product> productList;
        productList= this.productList.stream().filter(product -> product.getId()==idToSearch).collect(Collectors.toList());
        return productList.get(0);
    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }
}

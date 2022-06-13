package com.example.demo.infrastructure.adapters.secundary;

import com.example.demo.infrastructure.adapters.secondary.ProductRepositoryMySQLDatabase;
import com.example.demo.infrastructure.domain.Product;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductRepositoryMySQLDatabaseTest {

    private final ProductRepositoryMySQLDatabase sut = new ProductRepositoryMySQLDatabase();

    @AfterEach
    public void restoreDataBase(){
        ProductRepositoryMySQLDatabase.productList= new ArrayList<>();
    }

    @Test
    public void shouldAddProductDatabase() {
        final Product product = Product.builder().build();
        sut.addProduct(product);
        assertEquals(1, ProductRepositoryMySQLDatabase.productList.size());
    }

    @Test
    public void shouldDeleteProduct() {
        final int idTodelete = 1;
        final Product product=Product.builder().id(idTodelete).build();
        sut.addProduct(product);
        sut.deleteProduct(idTodelete);

        assertEquals(0,ProductRepositoryMySQLDatabase.productList.size());
    }

    @Test
    public void shouldFindProductById(){
        final int idToSearch=1;
        final Product product= Product.builder()
                .id(idToSearch)
                .build();
        sut.addProduct(product);

        Product productSearched=sut.findProductById(idToSearch);

        assertEquals(idToSearch,productSearched.getId());
    }

    @Test
    public void shouldReturnAllProducts(){
        final Product product1= Product.builder()
                .id(1)
                .build();
        final Product product2= Product.builder()
                .id(2)
                .build();
        final Product product3= Product.builder()
                .id(3)
                .build();
        final Product product4= Product.builder()
                .id(4)
                .build();

        sut.addProduct(product1);
        sut.addProduct(product2);
        sut.addProduct(product3);
        sut.addProduct(product4);

        List<Product> productList= sut.getProducts();
        assertEquals(4,productList.size());

        int idExpected=1;

        for (Product product: productList) {
            assertEquals(idExpected,product.getId());
            idExpected ++;
        }
    }

}

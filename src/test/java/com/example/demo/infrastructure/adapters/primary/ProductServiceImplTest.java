package com.example.demo.infrastructure.adapters.primary;

import com.example.demo.infrastructure.domain.Product;
import com.example.demo.infrastructure.ports.secondary.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

    ProductRepository productRepository = mock(ProductRepository.class);
    ProductService sut = new ProductServiceImpl(productRepository);

    @Test
    public void shouldCallRepositoryToSaveProduct() {
        Product product = Product.builder().build();
        sut.addProduct(product);

        verify(productRepository).addProduct(product);
    }

    @Test
    public void shouldCallRepositoryToDeleteProduct() {
        final int idToDelete = 1;
        sut.deleteProduct(idToDelete);
        verify(productRepository).deleteProduct(idToDelete);
    }

    @Test
    public void shouldCallRepositoryToFindProductById(){
        final int idToSearch=1;
        sut.findProductById(idToSearch);
        verify(productRepository).findProductById(idToSearch);
    }

    @Test
    public void shouldCallRepositoryToGetProducts(){
        sut.getProducts();
        verify(productRepository).getProducts();
    }
}

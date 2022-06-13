package com.example.demo.api.rest;

import com.example.demo.api.converters.ProductConverter;
import com.example.demo.api.vo.ProductVO;
import com.example.demo.infrastructure.adapters.primary.ProductService;
import com.example.demo.infrastructure.domain.Product;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    // simular una clase productConverters
    private final ProductConverter productConverter = mock(ProductConverter.class);
    private final ProductService productService = mock(ProductService.class);

    private final ProductController sut = new ProductController(productConverter, productService);

    @Test
    public void shouldCallServiceToAddProduct() {
        ProductVO productVO = ProductVO.builder().build();
        Product product = Product.builder().build();

        when(productConverter.convertToVO(any())).thenReturn(productVO);
        when(productConverter.convertToDomain(any())).thenReturn(product);

        sut.addProduct(productVO);

        verify(productService).addProduct(product);
    }

    @Test
    public void shouldCallServiceToDeleteProduct() {
        final int idToDelete = 1;
        sut.deleteProduct(idToDelete);
        verify(productService).deleteProduct(idToDelete);
    }

    @Test
    public void shoulCallServiceToFindProduct(){
        final int idToSearch=1;
        ProductVO productVO= ProductVO.builder()
                .id(idToSearch)
                .build();

        when(productConverter.convertToVO(any())).thenReturn(productVO);
        sut.finProductId(idToSearch);

        verify(productService).findProductById(idToSearch);
    }

    @Test
    public void shouldCallServiceToGetAllProducts(){
        sut.getProducts();
        verify(productService).getProducts();
    }
}

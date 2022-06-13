package com.example.demo.api.rest;

import com.example.demo.api.converters.ProductConverter;
import com.example.demo.api.vo.ProductVO;
import com.example.demo.infrastructure.adapters.primary.ProductService;
import com.example.demo.infrastructure.domain.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductConverter productConverter;
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductVO> addProduct(@RequestBody final ProductVO productVO) {
        final Product product = productConverter.convertToDomain(productVO);

        return ResponseEntity.of(Optional.of(productConverter.convertToVO(productService.addProduct(product))));
    }

    @DeleteMapping("/{idToDelete}")
    public void deleteProduct(@PathVariable final int idToDelete) {
        productService.deleteProduct(idToDelete);
    }

    @GetMapping("/{idToSearch}")
    public ResponseEntity<ProductVO> finProductId(@PathVariable final int idToSearch) {
        return ResponseEntity.of(Optional.of(productConverter.convertToVO(productService.findProductById(idToSearch))));
    }

    @GetMapping
    public ResponseEntity<List<ProductVO>> getProducts() {
        List<Product> productList=productService.getProducts();
        List<ProductVO> productVOList= productList.stream().map(product -> productConverter.convertToVO(product)).collect(Collectors.toList());
        return ResponseEntity.of(Optional.of(productVOList));
    }
}

package com.example.demo.api.converters;

import com.example.demo.api.vo.ProductVO;
import com.example.demo.infrastructure.domain.Product;
import com.example.demo.infrastructure.domain.ProductData;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductVO convertToVO(Product product) {
        return ProductVO.builder()
                .price(product.getProductData().getPrice())
                .company(product.getProductData().getCompany())
                .name(product.getProductData().getName())
                .id(product.getId())
                .build();
    }

    public Product convertToDomain(ProductVO productVO) {
        final ProductData productData= ProductData.builder()
                .name(productVO.getName())
                .price(productVO.getPrice())
                .company(productVO.getCompany())
                .build();
     return Product.builder()
             .id(productVO.getId())
             .productData(productData)
             .build();
    }
}

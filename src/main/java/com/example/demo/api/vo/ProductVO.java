package com.example.demo.api.vo;

import lombok.*;

@Getter
@Setter
@Builder
// constructores
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
    private int id;
    private String name;
    private double price;
    private String company;
}

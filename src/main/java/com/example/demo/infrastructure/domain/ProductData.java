package com.example.demo.infrastructure.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder //constructor
public class ProductData {

    private String name;
    private Double price;
    private String company;

}

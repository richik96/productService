package com.example.product_service_oct24.dtos;

import lombok.Data;

@Data

public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String description;
    private String category;
    private double price;
    private String image;

}

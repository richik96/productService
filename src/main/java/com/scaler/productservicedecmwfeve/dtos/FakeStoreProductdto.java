package com.scaler.productservicedecmwfeve.dtos;

import com.scaler.productservicedecmwfeve.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreProductdto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

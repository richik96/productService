package com.scaler.productservicedecmwfeve.dtos;

import com.scaler.productservicedecmwfeve.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String title;
    private double price;
    private Category category;
    private String  description;
    private String imageURL;
}

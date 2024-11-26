package com.scaler.productservicedecmwfeve.dtos;

//import com.scaler.productservicedecmwfeve.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FakeStoreProductdto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

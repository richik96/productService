package com.example.product_service_oct24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel{

    private String title;
    private Double price;

    @ManyToOne                  //cardinality(class : attribute) = product : category
    private Category category;
    private String description;
    private String image;


}

package com.example.product_service_oct24.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel{

    private String title;
    private Double price;

    //CasecadeType.ALL = if we delete a category, all the products in that category will be deleted
    //also if we delete a product, the category will be deleted
    @ManyToOne (fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
    //cardinality(class : attribute) = product : category
    @JsonBackReference
    private Category category;
    private String description;
    private String image;
    private int numberOfSales;
}

package com.example.product_service_oct24.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Category extends BaseModel{

    @OneToMany(mappedBy = "category")    //as in product class, category is the attribute and already defined the cardinality
    List<Product> products;
    private String name;
}

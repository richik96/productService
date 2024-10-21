package com.example.product_service_oct24.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity

public class Category extends BaseModel{

    @OneToMany(mappedBy = "category")//as in product class, category is the attribute and already defined the cardinality
    @JsonManagedReference
    List<Product> products;
    private String name;
}

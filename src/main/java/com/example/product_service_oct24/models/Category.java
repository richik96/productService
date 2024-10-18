package com.example.product_service_oct24.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Category extends BaseModel{

    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category", cascade = CascadeType.REMOVE)
    //by default fetch type is lazy for collections and eager for single objects
    //as in product class, category is the attribute and already defined the cardinality
    @JsonManagedReference
    List<Product> products;

}

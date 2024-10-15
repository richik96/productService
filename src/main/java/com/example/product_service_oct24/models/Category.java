package com.example.product_service_oct24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Category extends BaseModel{
    private String name;
}

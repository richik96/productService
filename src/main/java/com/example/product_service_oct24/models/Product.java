package com.example.product_service_oct24.models;

import lombok.Data;

@Data


public class Product {

    private int id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;


}

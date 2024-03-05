package com.scaler.productservicedecmwfeve.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private long id;
    private String tittle;
    private double price;
    private Category category;
    private String  description;

    private  String imageURL;
}

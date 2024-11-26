package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dtos.ProductDto;
import com.scaler.productservicedecmwfeve.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {



    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
    Product addNewProduct(ProductDto product);
    List<Product> saveAllProducts();
}
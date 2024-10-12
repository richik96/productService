package com.example.product_service_oct24.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product_service_oct24.models.Product;


@Service
public interface ProductService {

    public Product getSingleProduct(Long id);
    // public Product addNewProduct(Product entity);
    // public Product updateProduct(Long id, Product entity);
    // public void deleteProduct(Long id);
    public List<Product> getAllProducts();
}

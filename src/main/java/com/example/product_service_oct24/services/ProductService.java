package com.example.product_service_oct24.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product_service_oct24.Exceptions.ProductNotExistsException;
import com.example.product_service_oct24.models.Product;


@Service
public interface ProductService {

    public Product getSingleProduct(Long id) throws ProductNotExistsException;
    // public Product addNewProduct(Product entity);
    //public Product updateProduct(Long id, Product entity);
    public Product patchProduct(Long id, Product entity);
    public Product deleteProduct(Long id);
    public List<Product> getAllProducts();
}

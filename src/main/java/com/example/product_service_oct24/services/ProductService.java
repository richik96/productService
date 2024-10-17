package com.example.product_service_oct24.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product_service_oct24.Exceptions.ProductNotExistsException;
import com.example.product_service_oct24.models.Product;


@Service
public interface ProductService {

    public Product getSingleProduct(Long id) throws ProductNotExistsException;
    
    public Product patchProduct(Long id, Product entity);
    public String deleteProduct(Long id);
    public List<Product> getAllProducts();
    public Product addNewProduct(Product entity);
    public Product replaceProduct(Long id, Product entity) throws ProductNotExistsException;
}

package com.example.product_service_oct24.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product_service_oct24.Exceptions.ProductNotExistsException;
import com.example.product_service_oct24.models.Product;


@Service("selfProductService")
public class SelfProductService implements ProductService{

    @Override
    public Product deleteProduct(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product patchProduct(Long id, Product entity) {
        // TODO Auto-generated method stub
        return null;
    }

    

}

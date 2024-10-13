package com.example.product_service_oct24.Exceptions;



public class ProductNotExistsException extends Exception{

    public ProductNotExistsException(String message) {
        super(message);
    }
}

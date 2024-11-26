package com.scaler.productservicedecmwfeve.Exceptions;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(String productCannotBeNull) {
        super(productCannotBeNull);
    }
}

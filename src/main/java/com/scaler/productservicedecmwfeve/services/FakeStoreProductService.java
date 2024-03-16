package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dtos.FakeStoreProductdto;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductdto fakeStoreProduct) {
        Product product = new Product();
        product.setTitle(fakeStoreProduct.getTitle());
        product.setId(fakeStoreProduct.getId());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageURL(fakeStoreProduct.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        return product;
    }
    @Override
    public Product getSingleProduct (Long id){
        FakeStoreProductdto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +id, FakeStoreProductdto.class);


        return convertFakeStoreProductToProduct(productDto);
    }

    /*@Override
    public Product addNewProduct(Product product) {
        return null;
    }*/

}

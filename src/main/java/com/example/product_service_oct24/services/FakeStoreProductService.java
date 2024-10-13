package com.example.product_service_oct24.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.example.product_service_oct24.dtos.FakeStoreProductDto;
import com.example.product_service_oct24.models.Category;
import com.example.product_service_oct24.models.Product;

@Service
public class FakeStoreProductService implements ProductService{


    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(new Category());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        return product;
    }

    // private List<Product> convertFakeProductstoList(List<FakeStoreProductDto> fakeStoreProductDtos) {
    //     List<Product> products = new ArrayList<>();
    //     for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
    //         products.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
    //     }
    //     return products;
    // }
    
    @Override
    public Product getSingleProduct(Long id) {

        //making a get request with the help of restTemplate bean/object to the fakestore API.
        //The fakestore API returns a JSON response which is then converted to a Product object.
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +id,
                    FakeStoreProductDto.class
                    );
        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {

        List<FakeStoreProductDto> fakeStoreProductDtos = Arrays.asList(restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class)
                );
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
        }

        return products;
    }

    @Override
    public Product updateProduct(Long id, Product entity) {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(new FakeStoreProductDto(), FakeStoreProductDto.class);

        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new 
                                                        HttpMessageConverterExtractor<>(FakeStoreProductDto.class, 
                                                        restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        if (response != null) {
            System.out.println("Product updated");
        }
        return convertFakeStoreProductToProduct(response);
    }
}

package com.scaler.productservicedecmwfeve.services;

import com.scaler.productservicedecmwfeve.dtos.FakeStoreProductdto;
import com.scaler.productservicedecmwfeve.dtos.ProductDto;
import com.scaler.productservicedecmwfeve.models.Category;
import com.scaler.productservicedecmwfeve.models.Product;

import com.scaler.productservicedecmwfeve.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    
    @Autowired
    private RestTemplate restTemplate;

    private ProductRepository productRepository;
    // public FakeStoreProductService(RestTemplate restTemplate) {
    //     this.restTemplate = restTemplate;
    // }

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

    @Override
    public List<Product> getAllProducts() {
        //List<FakeStoreProductdto> response = restTemplate.getForObject("https://fakestoreapi.com/products", List.class);
        // ==> here at runtime the response will not get the datatype(FakeStoredto) class due to JAVA generics. It will just convert it into a list.
        //List<Product> answer = new ArrayList<>();
        //
        //}
        //return null;

        //runtime
        FakeStoreProductdto[] response = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductdto[].class);
        //Arrays can work but not Listll
        List<Product> answer = new ArrayList<>();
        for(FakeStoreProductdto dto: response) {
            answer.add(convertFakeStoreProductToProduct(dto));

        }
        return answer;
    }

    @Override
    public Product addNewProduct(ProductDto product) {
        Product p = new Product();
        p.setTitle(product.getTitle());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setImageURL(product.getImageURL());
        //Category category = new Category();
        p.setCategory(product.getCategory());
        Product savedProduct = productRepository.save(p);
        return savedProduct;
    }
    @Override
    public Product saveProductToDb(Long id) {
        FakeStoreProductdto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/" +id, FakeStoreProductdto.class);
        Product product = convertFakeStoreProductToProduct(productDto);
        productRepository.save(product);
        return product;
    }
    @Override
    @Transactional
    public List<Product> saveAllProducts() throws RestClientException {
        FakeStoreProductdto[] fakeStoreProductdto = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductdto[].class);
//        List<Product> products = new ArrayList<>();
//        for(FakeStoreProductdto productDto: fakeStoreProductdto) {
//            products.add(convertFakeStoreProductToProduct(productDto));
//        }
//        productRepository.saveAll(products);
//        return products;
        List<Product> products =  Arrays.stream(fakeStoreProductdto).map(this::convertFakeStoreProductToProduct).toList();
        if(products.isEmpty() || products == null) {
            throw new RestClientException("No products found");
        }
        productRepository.saveAll(products);
        return products;
    }
    /*@Override
    public Product addNewProduct(Product product) {
        return null;
    }*/

}

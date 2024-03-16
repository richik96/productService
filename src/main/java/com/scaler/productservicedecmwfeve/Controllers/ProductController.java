package com.scaler.productservicedecmwfeve.Controllers;


import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping() //this will return all product details
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    @GetMapping("/{id}") //to get all details for a specific product
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }


    @PostMapping() //to add a new
    public Product addNewProduct(@RequestBody Product product) {
        Product p = new Product();
        p.setTitle("A new Product added");
        return p;
    }

    @PatchMapping("/{id}") //partial updation we use patchmapping
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return  new Product();
    }

    @PutMapping("/{id}") //to update a whole product
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return  new Product();
    }

    @DeleteMapping("/{id}") //to delete a product
    public void deleteProduct(@PathVariable("id") Long id){

    }
}

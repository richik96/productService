package com.example.product_service_oct24.Controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.product_service_oct24.models.Product;
import com.example.product_service_oct24.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/products")                //common prefix of the path of all the methods under this class

public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<Product> getAllProducts() {

        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product entity) {
        
        Product p = new Product(); 
        p.setTitle("New Product added");
        return p;
    }
    
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product entity) {
        return new Product();
    }

    @PutMapping("path/{id}")
    public String putMethodName(@PathVariable("id") String id, @RequestBody String entity) {
        
        return entity;
    }

    @DeleteMapping("/{id}")
    public String deleteMethodName(@PathVariable("id") String id) {
        return "Deleted";
    }
}

package com.example.product_service_oct24.Controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.product_service_oct24.models.Product;
import com.example.product_service_oct24.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Product>> getAllProducts() {
        // to customize the response status we have to put return type in a ResponseEntity<class>
        //with HttpStatus enum we will be able to send status response to the client as well
        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getAllProducts(), HttpStatus.CONFLICT); //HttpStatus, we can set anything to show as reponse status
        return response;
        //by default it will send 200/ok status if the response is fine
        //return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) {
        ResponseEntity<Product> response = new ResponseEntity<>(productService.getSingleProduct(id), HttpStatus.CONTINUE);
        return response;
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product entity) {
        
        Product p = new Product(); 
        p.setTitle("New Product added");
        return p;
    }
    
    // @PatchMapping("/{id}")
    // public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product entity) {
    //     return productService.updateProduct(id, entity);
    // }

    @PutMapping("path/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product entity) {
        ResponseEntity<Product> response = new ResponseEntity<>(productService.updateProduct(id, entity), HttpStatus.FOUND);
        return response;
    }

    @DeleteMapping("/{id}")
    public String deleteMethodName(@PathVariable("id") String id) {
        return "Deleted";
    }
}

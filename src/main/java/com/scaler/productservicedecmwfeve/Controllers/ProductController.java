package com.scaler.productservicedecmwfeve.Controllers;


import com.scaler.productservicedecmwfeve.Exceptions.ProductNotFoundException;
import com.scaler.productservicedecmwfeve.dtos.ProductDto;
import com.scaler.productservicedecmwfeve.models.Product;
import com.scaler.productservicedecmwfeve.services.FakeStoreProductService;
import com.scaler.productservicedecmwfeve.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private FakeStoreProductService productService;
    public ProductController(FakeStoreProductService productService) {
        this.productService = productService;
    }
    @GetMapping() //this will return all product details
    public ResponseEntity<List<Product>> getAllProducts() {


        return ResponseEntity.status(200)
                .header("Content-Type", "application/json")
                .body(productService.getAllProducts());
    }

    //saving all products from fakestrore to our database
    @PostMapping("/saveAll")
    public ResponseEntity<?> saveAllProducts() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Content-Type", "application/json")
                .body(productService.saveAllProducts());
    }

    @GetMapping("/{id}") //to get all details for a specific product
    public ResponseEntity<?> getSingleProduct(@PathVariable("id") Long id) {
        return ResponseEntity.status(200)
                .header("Content-Type", "application/json")
                .body(productService.getSingleProduct(id));
    }


    @PostMapping() //to add a new
    public ResponseEntity<?> addNewProduct(@RequestBody ProductDto product) throws ProductNotFoundException {
        if(product.equals(null)) {
            throw new ProductNotFoundException("Product cannot be null");
        }
        return ResponseEntity.status(201)
                .header("Content-Type", "application/json")
                .body(productService.addNewProduct(product));
    }
//
//    @PatchMapping("/{id}") //partial updation we use patchmapping
//    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
//        return new Product();
//    }
//
//    @PutMapping("/{id}") //to update a whole product
//    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
//        return  new Product();
//    }
//
//    @DeleteMapping("/{id}") //to delete a product
//    public void deleteProduct(@PathVariable("id") Long id){
//
//    }
}

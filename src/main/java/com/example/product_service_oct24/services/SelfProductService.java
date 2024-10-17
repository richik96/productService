package com.example.product_service_oct24.services;

import java.util.List;

import java.util.Optional;

import com.example.product_service_oct24.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_service_oct24.Exceptions.ProductNotExistsException;
import com.example.product_service_oct24.models.Product;
import com.example.product_service_oct24.repositories.CategoryRepository;
import com.example.product_service_oct24.repositories.ProductRepository;

import javax.swing.text.html.Option;


@Service("selfProductService")
public class SelfProductService implements ProductService{


    private ProductRepository productRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    private CategoryRepository categoryRepository;

    @Override
    public String deleteProduct(Long id) {
        categoryRepository.deleteById(id);
        productRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()) {
            throw new ProductNotExistsException("Product with id:" +id + " does not exist!!");
        }
        return productOptional.get();
    }

    @Override
    public Product patchProduct(Long id, Product entity) {

        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException();
        }

        Product savedProduct = productOptional.get();
        if(savedProduct.getTitle() != null && entity.getTitle() != null) {
            savedProduct.setTitle(entity.getTitle());
        }
        if(savedProduct.getPrice() != null && entity.getPrice() != null) {
            savedProduct.setPrice(entity.getPrice());
        }
        if(savedProduct.getDescription() != null && entity.getDescription() != null){
            savedProduct.setDescription(entity.getDescription());
        }
        if(savedProduct.getImage() != null && entity.getImage() != null){
            savedProduct.setImage(entity.getImage());
        }
        if(savedProduct.getCategory() != null && entity.getCategory() != null){
            savedProduct.setCategory(entity.getCategory());
        }


        return productRepository.save(savedProduct);
    }
    @Override
    public Product addNewProduct(Product entity) {

        Category category = entity.getCategory();
        if(category.getId() == null) {
            Category savedCategory = categoryRepository.save(category);
            entity.setCategory(savedCategory);
        }

        Optional<Category> categoryOptional = categoryRepository.findByName(entity.getCategory().getName());

        if(categoryOptional.isEmpty()) {
            entity.setCategory(categoryRepository.save(entity.getCategory()));
        }
        else {
            entity.setCategory(categoryOptional.get());
        }
        return productRepository.save(entity);
    }

    @Override
    public Product replaceProduct(Long id, Product entity) throws ProductNotExistsException {

        if(! productRepository.existsById(id))
        {
            throw new ProductNotExistsException("No Product with id: " + id + " exists!!");
        }
        return productRepository.save(entity);
    }

    

}

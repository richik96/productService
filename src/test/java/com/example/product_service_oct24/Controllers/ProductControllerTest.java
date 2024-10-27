package com.example.product_service_oct24.Controllers;

import com.example.product_service_oct24.Exceptions.ProductNotExistsException;
import com.example.product_service_oct24.models.Product;
import com.example.product_service_oct24.repositories.ProductRepository;
import com.example.product_service_oct24.services.SelfProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;    //injecting the controller

    @MockBean
    private SelfProductService productService;  //mocking the service

    @MockBean
    private ProductRepository productRepository;  //mocking the repository

    @Test
    void testProductsSameAsService() {
        //Arrange
        List<Product> products = new ArrayList<>();
        Product p1 = new Product();
        p1.setTitle("iPhone16");
        p1.setDescription("Best phone");
        products.add(p1);

        Product p2 = new Product();
        p1.setTitle("iPhone15");
        p1.setDescription("Best phone");
        products.add(p2);

        Product p3 = new Product();
        p1.setTitle("iPhone13");
        p1.setDescription("Best phone");
        products.add(p3);
        when(
                productService.getAllProducts()
        ).thenReturn(
                products
        );

        //Act
        //ResponseEntity<List<Product>> response =  productController.getAllProducts();

        //Assert
        //List<Product> productResponse = response.getBody();

        //assertEquals(products.size(), productResponse.size());
    }



    @Test
    void testnonExistingProductthowsException() throws ProductNotExistsException {

        //Arrange
        when(
                productRepository.findById(1L))
                .thenReturn(
                        Optional.empty()
                );

        when(
                productService.getSingleProduct(10L)
        ).thenCallRealMethod();



        //Act
//        assertThrows(
//                ProductNotExistsException.class,
//                () -> productController.getSingleProduct(10L)
//        );
    }
}
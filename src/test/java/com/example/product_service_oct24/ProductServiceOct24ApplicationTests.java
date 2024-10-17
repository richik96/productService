package com.example.product_service_oct24;

import com.example.product_service_oct24.Projections.ProductwithIdandTitle;
import com.example.product_service_oct24.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.product_service_oct24.repositories.ProductRepository;

import java.util.List;

@SpringBootTest
class ProductServiceOct24ApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {

		productRepository.findByTitle("Richik");
	}

	@Test
	void testQueries() {


		List<ProductwithIdandTitle> products = productRepository.something();

		for(ProductwithIdandTitle product: products) {
			System.out.println(product.getId());
			System.out.println(product.getTitle());
		}
	}

}

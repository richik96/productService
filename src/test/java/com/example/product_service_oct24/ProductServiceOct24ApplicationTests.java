package com.example.product_service_oct24;

import com.example.product_service_oct24.Projections.ProductwithIdandTitle;
import com.example.product_service_oct24.models.Category;
import com.example.product_service_oct24.models.Product;
import com.example.product_service_oct24.repositories.CategoryRepository;
import com.example.product_service_oct24.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceOct24ApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	private  CategoryRepository categoryRepository;

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

		//List<ProductwithIdandTitle> products1 = productRepository.something();

		Optional<Category> c = categoryRepository.findById(202L);
		if(true) {
			Category c2 = c.get();
			List<Product> p2 = c2.getProducts();
			for(Product p: p2) {
				System.out.println(p.getTitle());
			}
		}
	}

}

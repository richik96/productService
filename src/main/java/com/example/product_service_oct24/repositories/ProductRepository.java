package com.example.product_service_oct24.repositories;

import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.product_service_oct24.Projections.ProductwithIdandTitle;
import com.example.product_service_oct24.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitle(String title);

    Optional<Product> findById(Long id);

    Product save(Product product);

    @Query("select p.description, p.title from product p where p.price >10000 and p.description like '%best%'")
    Product[] doSomething();

    @Query("select p.id as id, p.title as title from product p where p.id = 2")
    List<ProductwithIdandTitle> something();
}

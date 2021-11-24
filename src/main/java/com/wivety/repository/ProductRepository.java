package com.wivety.repository;

import com.wivety.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
            value = "SELECT * FROM product p WHERE p.id = :product and p.active = TRUE",
            nativeQuery = true
    )
    Optional<Product> getByProductById(@Param("product") String product);
}

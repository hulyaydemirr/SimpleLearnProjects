package com.example.sportyShoes.repository;

import com.example.sportyShoes.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByCategoryIdAndProductName(Integer cId, String productName);
}

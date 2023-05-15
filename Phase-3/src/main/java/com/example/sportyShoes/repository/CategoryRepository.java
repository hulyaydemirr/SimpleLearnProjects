package com.example.sportyShoes.repository;

import com.example.sportyShoes.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsByCategoryName(String name);
}

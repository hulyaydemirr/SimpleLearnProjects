package com.example.sportyShoes.service;

import com.example.sportyShoes.model.Category;
import com.example.sportyShoes.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        try{
            log.info("[getAllCategories] started!");
            return categoryRepository.findAll();
        }catch (Exception e){
            log.error("[getAllCategories] Exception occurred!", e);
            return Collections.emptyList();
        }
    }

    public boolean insertCategory(Category category){
        try {
            log.info("[insertCategory] started! record will be inserted! :: category ={}", category);
            if(!isCategoryAlreadyExists(category)){
                categoryRepository.save(category);
                log.info("[insertCategory] new category inserted! :: category ={}", category);
                return true;
            }
        }catch (Exception e){
            log.error("[insertCategory] Exception occurred! Category could not be added!");
        }
        return false;
    }

    public boolean isCategoryAlreadyExists(Category category){
        try {
            log.info("[isCategoryAlreadyExists] started! existence will be checked! :: category ={}", category);
            return categoryRepository.existsByCategoryName(category.getCategoryName());
        }catch (DataAccessException dataAccessException){
            log.error("[isCategoryAlreadyExists] Exception occurred while getting data from db!", dataAccessException);
        }catch (Exception e){
            log.error("[isCategoryAlreadyExists] Exception occurred!", e);
        }
        return true;
    }
}

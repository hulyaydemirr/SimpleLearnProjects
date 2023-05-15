package com.example.sportyShoes.controller;

import com.example.sportyShoes.model.Category;
import com.example.sportyShoes.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/addCategoryPage")
    public String addCategoryPage(Model model) {
        model.addAttribute("category", new Category());
        return "addCategoryPage";
    }

    @GetMapping(value = "/viewCategoryPage")
    public String viewCategoryPage(Model model) {
        model.addAttribute("category", new Category());
        List<Category> categories = categoryService.getAllCategories();
        if(!categories.isEmpty()){
            log.info("[viewCategoryPage] categories will be shown in page! categories={}", categories);
            model.addAttribute("category",categories);
            return "viewCategoryPage";
        }
        log.warn("[viewCategoryPage] there is no categories!");
        model.addAttribute("categoryInfo", "there isn't any category");
        model.addAttribute("category", Collections.emptyList());
        return "viewCategoryPage";
    }

    @PostMapping(value = "/addCategory")
    public String addCategory(@ModelAttribute Category category, Model model){
        boolean categoryInserted = categoryService.insertCategory(category);
        if(categoryInserted){
            model.addAttribute("categoryInfoMessage","Category created!");
            return "addCategoryPage";
        }
        model.addAttribute("categoryInfoMessage","Category could not be created!");
        return "addCategoryPage";
    }
}

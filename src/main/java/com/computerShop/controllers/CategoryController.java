package com.computerShop.controllers;

import com.computerShop.Entity.Category;
import com.computerShop.Entity.ProductCategory;
import com.computerShop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping(value = "/api/categories")
    List<Category> getCategory() {
        return categoryService.getCategory();
    }

    @GetMapping(value = "/api/categories/{id}", produces = "application/json")
    public List<ProductCategory> getCurrentCategoryWithProducts(@PathVariable Long id) {
        return categoryService.getCurrentCategoryWithProducts(id);
    }
}

package com.computerShop.controllers;

import com.computerShop.Entity.Category;
import com.computerShop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value = "/categories")
    List<Category> getCategory() {
        return categoryRepository.findAll();
    }


}

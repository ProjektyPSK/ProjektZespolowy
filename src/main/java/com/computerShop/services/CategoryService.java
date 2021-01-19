package com.computerShop.services;

import com.computerShop.Entity.Category;
import com.computerShop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {


    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    public Category getCurrentCategoryWithProducts(Long id) {

        Optional<Category> byId = categoryRepository.findById(id);

        return byId.get();
    }

}

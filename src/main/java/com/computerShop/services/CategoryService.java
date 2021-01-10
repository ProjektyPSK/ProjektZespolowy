package com.computerShop.services;

import com.computerShop.Entity.Category;
import com.computerShop.Entity.ProductCategory;
import com.computerShop.repository.CategoryRepository;
import com.computerShop.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private ProductCategoryRepository productCategoryRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ProductCategoryRepository productCategoryRepository, CategoryRepository categoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }

    public List<ProductCategory> getCurrentCategoryWithProducts(Long id){
        List<ProductCategory> productCategories = new ArrayList<>();

        Optional<Category> byId = categoryRepository.findById(id);
        if(byId.isPresent()){
        productCategories = productCategoryRepository.findAllByCategory(byId.get());
        }
        return productCategories;
    }

}

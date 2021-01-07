package com.computerShop.controllers;

import com.computerShop.Entity.Product;
import com.computerShop.Entity.View;
import com.computerShop.repository.ProductRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    @JsonView(View.Summary.class)
    @GetMapping("/products")
    public List<Product> all() {
        List<Product> all = productRepository.findAll();
        return all;
    }

    @GetMapping(value = "/admin/oneProduct/{id}")
    Product getProduct(@PathVariable long id) {
        return productRepository.findById(id).get();
    }


    @GetMapping("/admin/products")
    List<Product> getAll() {
        return productRepository.findAll();
    }
}

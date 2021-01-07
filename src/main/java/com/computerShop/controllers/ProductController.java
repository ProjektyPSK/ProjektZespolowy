package com.computerShop.controllers;

import com.computerShop.model.Product;
import com.computerShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/api/product")
    List<Product> all() {
        return productRepository.findAll();
    }

    @GetMapping(value = "/admin/oneProduct/{id}")
    Product getProduct(@PathVariable long id) {
        return productRepository.findById(id).get();
    }

}

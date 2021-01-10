package com.computerShop.controllers;

import com.computerShop.Entity.Product;
import com.computerShop.Entity.View;
import com.computerShop.services.ProductService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @JsonView(View.Summary.class)
    @GetMapping("/products")
    public List<Product> all() {
        List<Product> allProducts = productService.findAllProducts();
        return allProducts;
    }

    @GetMapping(value = "/product/{id}")
    public Product getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/admin/products")
    public List<Product> getAll() {
        return productService.findAllProducts();
    }
}

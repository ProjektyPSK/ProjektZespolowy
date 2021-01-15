package com.computerShop.controllers;

import com.computerShop.Entity.Product;
import com.computerShop.Utils.View;
import com.computerShop.services.ProductService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @JsonView(View.Products.class)
    @GetMapping("/products")
    public List<Product> all() {
        List<Product> allProducts = productService.findAllProducts();
        return allProducts;
    }

    @JsonView(View.Product.class)
    @GetMapping(value = "/product/{id}")
    public Product getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @JsonView({View.Product.class})
    @GetMapping("/admin/products")
    public List<Product> getAll() {
        return productService.findAllProducts();
    }

    @GetMapping("/admin/addProduct")
    @ResponseBody
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/product/find")
    @ResponseBody
    @JsonView(View.Product.class)
    public List<Product> findAllByTitleLike(@RequestParam("title") String title){
        return productService.findAllByTitleLike(title);
    }
}

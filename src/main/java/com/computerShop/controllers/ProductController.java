package com.computerShop.controllers;

import com.computerShop.entity.Product;
import com.computerShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    List<Product> all(){
        return productRepository.findAll();
    }

    @PostMapping(value = "/one", headers = "Accept=application/json")
    @ResponseBody
    @Transactional
    Product getProduct(@RequestParam(value = "id") long id){
        return productRepository.findById(id).get();
    }

}

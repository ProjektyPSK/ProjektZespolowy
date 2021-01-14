package com.computerShop.services;

import com.computerShop.Entity.Product;
import com.computerShop.Entity.ProductMeta;
import com.computerShop.repository.ProductMetaRepository;
import com.computerShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMetaRepository productMetaRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(Long id){
        return productRepository.findById(id).get();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAllByTitleLike(String title) {
        return productRepository.findAllByPartOfTitle(title.toUpperCase(Locale.ROOT));
    }
}

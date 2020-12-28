package com.computerShop.entity;

import javax.persistence.*;

@Entity
@Table(schema = "ComputerShop")
public class ProductMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productMeta;
    @ManyToOne
    private Product product;
    private String key;
    private String content;

    public ProductMeta(Long productMeta, Product product, String key, String content) {
        this.productMeta = productMeta;
        this.product = product;
        this.key = key;
        this.content = content;
    }

    public ProductMeta() {
    }

    public Long getProductMeta() {
        return productMeta;
    }

    public void setProductMeta(Long productMeta) {
        this.productMeta = productMeta;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}

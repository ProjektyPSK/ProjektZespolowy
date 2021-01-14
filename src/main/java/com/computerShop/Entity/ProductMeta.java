package com.computerShop.Entity;

import com.computerShop.Utils.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(schema = "ComputerShop")
public class ProductMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Category.class)
    private Long idProductMeta;
    @ManyToOne()
    @JsonIgnore
    private Product product;
    @JsonView(View.Category.class)
    private String key;
    @JsonView(View.Category.class)
    private String content;

    public ProductMeta(Long idProductMeta, Product product, String key, String content) {
        this.idProductMeta = idProductMeta;
        this.product = product;
        this.key = key;
        this.content = content;
    }

    public ProductMeta() {
    }

    public Long getIdProductMeta() {
        return idProductMeta;
    }

    public void setIdProductMeta(Long productMeta) {
        this.idProductMeta = productMeta;
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

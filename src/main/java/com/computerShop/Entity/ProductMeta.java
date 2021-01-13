package com.computerShop.Entity;

import javax.persistence.*;

@Entity
@Table(schema = "ComputerShop")
public class ProductMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProductMeta;
    @ManyToOne
    @JoinColumn(name="product_id", nullable = false, insertable = false)
    private Product product;
    private String key;
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

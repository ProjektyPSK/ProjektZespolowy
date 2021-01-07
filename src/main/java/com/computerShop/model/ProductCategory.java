package com.computerShop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "ComputerShop")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productCategory;
    @NotNull
    @ManyToOne
    private Category category;
    @NotNull
    @ManyToOne
    private Product product;

    public ProductCategory(Long productCategory, @NotNull Category category, @NotNull Product product) {
        this.productCategory = productCategory;
        this.category = category;
        this.product = product;
    }

    public ProductCategory() {
    }

    public Long getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Long productCategory) {
        this.productCategory = productCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

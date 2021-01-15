package com.computerShop.Entity;

import com.computerShop.Utils.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(schema = "ComputerShop")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({View.Product.class})
    private Long idCategory;
    @NotNull
    @JsonView(View.Product.class)
    private String title;
    @JsonView(View.Product.class)
    private String metaTitle;
    @NotNull
    @JsonView(View.Product.class)
    private String slug;
    @JsonView(View.Product.class)
    private String content;
    @OneToMany(mappedBy = "category")
    @JsonView(View.Product.class)
    private Set<Product> product;

    public Category(Long idCategory, @NotNull String title, String metaTitle, @NotNull String slug, String content, Set<Product> product) {
        this.idCategory = idCategory;
        this.title = title;
        this.metaTitle = metaTitle;
        this.slug = slug;
        this.content = content;
        this.product = product;
    }

    public Category() {
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}

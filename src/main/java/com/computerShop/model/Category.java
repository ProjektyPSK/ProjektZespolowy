package com.computerShop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "ComputerShop" )
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategory;
    @NotNull
    private String title;
    private String metaTitle;
    @NotNull
    private String slug;
    private String content;

    public Category(Long idCategory, @NotNull String title, String metaTitle, @NotNull String slug, String content) {
        this.idCategory = idCategory;
        this.title = title;
        this.metaTitle = metaTitle;
        this.slug = slug;
        this.content = content;
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
}

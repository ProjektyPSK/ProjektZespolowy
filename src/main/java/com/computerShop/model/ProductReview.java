package com.computerShop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(schema = "ComputerShop")
public class ProductReview {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProductReview;
    @NotNull
    @ManyToOne
    private Product product;
    @NotNull
    private String title;
    private int rating;
    @NotNull
    private boolean published;
    @NotNull
    private LocalDate createdAt;
    private LocalDate publishedAt;
    private String content;

    public ProductReview(@NotNull Long idProductReview, @NotNull Product product, @NotNull String title, int rating,
                         @NotNull boolean published, @NotNull LocalDate createdAt, LocalDate publishedAt, String content) {
        this.idProductReview = idProductReview;
        this.product = product;
        this.title = title;
        this.rating = rating;
        this.published = published;
        this.createdAt = createdAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public ProductReview() {
    }

    public Long getIdProductReview() {
        return idProductReview;
    }

    public void setIdProductReview(Long idProductReview) {
        this.idProductReview = idProductReview;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


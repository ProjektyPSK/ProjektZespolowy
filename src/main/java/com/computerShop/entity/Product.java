package com.computerShop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(schema = "ComputerShop")
public class Product {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;
    @NotNull
    @ManyToOne
    private User user;
    @NotNull
    private String title;
    private String metaTitle;
    private String summary;
    @NotNull
    private String sku;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal price;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal discount;
    @NotNull
    private int quantity;
    @NotNull
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate publishedAt;
    private String content;
    @OneToOne
    private Images images;


    public Product(@NotNull Long idProduct, @NotNull User user, @NotNull String title, String metaTitle, String summary,
                   @NotNull String sku, @NotNull BigDecimal price, @NotNull BigDecimal discount, @NotNull int quantity,
                   @NotNull LocalDate createdAt, LocalDate updatedAt, LocalDate publishedAt, String content, Images images) {
        this.idProduct = idProduct;
        this.user = user;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.sku = sku;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.content = content;
        this.images = images;
    }

    public Product() {
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
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

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}

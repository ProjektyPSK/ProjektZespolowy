package com.computerShop.Entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(schema = "ComputerShop")
@TypeDefs(@TypeDef(name = "string-array", typeClass = StringArrayType.class))
public class Product implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;
    @NotNull
    @ManyToOne
    private Users users;
    @NotNull
    @JsonView(View.Summary.class)
    private String title;
    @JsonView(View.Summary.class)
    private String metaTitle;
    @JsonView(View.Summary.class)
    private String summary;
    @NotNull
    @JsonView(View.Summary.class)
    private String sku;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    @JsonView(View.Summary.class)
    private BigDecimal price;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    @JsonView(View.Summary.class)
    private BigDecimal discount;
    @NotNull
    @JsonView(View.Summary.class)
    private int quantity;
    @NotNull
    @JsonView(View.Summary.class)
    private LocalDate createdAt;
    @JsonView(View.Summary.class)
    private LocalDate updatedAt;
    @JsonView(View.Summary.class)
    private LocalDate publishedAt;
    @JsonView(View.Summary.class)
    @Column(length = 1000)
    private String content;

    @org.hibernate.annotations.Type(type = "string-array")
    @Column(columnDefinition = "text[]")
    @JsonView(View.Summary.class)
    private String[] images;

    public Product(@NotNull Long idProduct, @NotNull Users users, @NotNull String title, String metaTitle, String summary,
                   @NotNull String sku, @NotNull BigDecimal price, @NotNull BigDecimal discount, @NotNull int quantity,
                   @NotNull LocalDate createdAt, LocalDate updatedAt, LocalDate publishedAt, String content, String[] images) {
        this.idProduct = idProduct;
        this.users = users;
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

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
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

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}

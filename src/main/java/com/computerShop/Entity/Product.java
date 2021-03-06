package com.computerShop.Entity;

import com.computerShop.Utils.View;
import com.fasterxml.jackson.annotation.JsonView;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "ComputerShop")
@TypeDefs(@TypeDef(name = "string-array", typeClass = StringArrayType.class))
public class Product implements Serializable {

    @Id
    @NotNull
    @JsonView({View.Products.class, View.Cart.class, View.Product.class, View.Category.class})
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;
    @NotNull
    @ManyToOne
    private Users users;
    @NotNull
    @JsonView({View.Products.class, View.Cart.class, View.Product.class, View.Category.class})
    private String title;
    @NotNull
    @JsonView({View.Products.class, View.Cart.class, View.Product.class, View.Category.class})
    private String sku;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    @JsonView({View.Products.class, View.Cart.class, View.Product.class, View.Category.class})
    private BigDecimal price;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    @JsonView({View.Products.class, View.Cart.class, View.Product.class, View.Category.class})
    private BigDecimal discount;
    @NotNull
    @JsonView({View.Products.class, View.Cart.class, View.Product.class, View.Category.class})
    private int quantity;
    @NotNull
    @JsonView({View.Products.class, View.Cart.class, View.Product.class, View.Category.class})
    private LocalDate createdAt;
    @JsonView({View.Products.class, View.Cart.class, View.Product.class, View.Category.class})
    private LocalDate updatedAt;
    @JsonView({View.Products.class, View.Cart.class, View.Product.class, View.Category.class})
    @Column(columnDefinition = "text")
    private String content;
    @OneToMany(mappedBy = "product")
    @JsonView({View.Cart.class, View.Product.class, View.Category.class})
    private Set<ProductMeta> metaProduct = new HashSet<>();
    @ManyToOne()
    @JsonView(View.Product.class)
    private Category category;
    @OneToMany(mappedBy = "product")
    @JsonView(View.Cart.class)
    private Set<Carts> carts;
    @org.hibernate.annotations.Type(type = "string-array")
    @Column(columnDefinition = "text[]")
    @JsonView({View.Products.class, View.Cart.class, View.Product.class, View.Category.class})
    private String[] images;

    public Product(@NotNull Long idProduct, @NotNull Users users, @NotNull String title,
                   @NotNull String sku, @NotNull BigDecimal price, @NotNull BigDecimal discount, @NotNull int quantity,
                   @NotNull LocalDate createdAt, LocalDate updatedAt,
                   String content, Set<ProductMeta> metaProduct, Category category, Set<Carts> carts, String[] images) {
        this.idProduct = idProduct;
        this.users = users;
        this.title = title;
        this.sku = sku;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.content = content;
        this.metaProduct = metaProduct;
        this.category = category;
        this.carts = carts;
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

    public Set<ProductMeta> getMetaProduct() {
        return metaProduct;
    }

    public void setMetaProduct(Set<ProductMeta> productMeta) {
        this.metaProduct = productMeta;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Carts> getCarts() {
        return carts;
    }

    public void setCarts(Set<Carts> carts) {
        this.carts = carts;
    }
}

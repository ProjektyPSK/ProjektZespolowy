package com.computerShop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(schema = "ComputerShop")
public class CartItem {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCartItem;
    @NotNull
    @ManyToOne
    private Product product;
    @NotNull
    @ManyToOne
    private Cart cart;
    @NotNull
    private String sku;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal price;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal discount;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private int quantity;
    @NotNull
    private boolean active;
    @NotNull
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String content;

    public CartItem(@NotNull Long idCartItem, @NotNull Product product, @NotNull Cart cart, @NotNull String sku,
                    @NotNull BigDecimal price, @NotNull BigDecimal discount, @NotNull int quantity, @NotNull boolean active,
                    @NotNull LocalDate createdAt, LocalDate updatedAt, String content) {
        this.idCartItem = idCartItem;
        this.product = product;
        this.cart = cart;
        this.sku = sku;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.content = content;
    }

    public CartItem() {
    }

    public Long getIdCartItem() {
        return idCartItem;
    }

    public void setIdCartItem(Long idCartItem) {
        this.idCartItem = idCartItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
}

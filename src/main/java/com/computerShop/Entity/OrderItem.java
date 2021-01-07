package com.computerShop.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(schema = "ComputerShop")
public class OrderItem {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrderItem;
    @ManyToOne
    @NotNull
    private Product product;
    @ManyToOne
    @NotNull
    private Order order;
    @NotNull
    private String sku;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal price;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal discount;
    @NotNull
    @Column(columnDefinition = "SMALLINT default 0")
    private int quantity;
    @NotNull
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String content;

    public OrderItem(@NotNull Long idOrderItem, @NotNull Product product, @NotNull Order order, @NotNull String sku,
                     @NotNull BigDecimal price, @NotNull BigDecimal discount, @NotNull int quantity,
                     @NotNull LocalDate createdAt, LocalDate updatedAt, String content) {
        this.idOrderItem = idOrderItem;
        this.product = product;
        this.order = order;
        this.sku = sku;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.content = content;
    }

    public OrderItem() {
    }

    public Long getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Long idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
}

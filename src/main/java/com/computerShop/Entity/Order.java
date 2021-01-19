package com.computerShop.Entity;

import com.computerShop.Utils.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(schema = "ComputerShop")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.Order.class)
    private Long idOrder;
    @ManyToOne
    private Users users;
    @NotNull
    @Enumerated(EnumType.STRING)
    @JsonView(View.Order.class)
    private Status status;
    @NotNull
    @JsonView(View.Order.class)
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal subTotal;
    @NotNull
    @JsonView(View.Order.class)
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal tax;
    @NotNull
    @JsonView(View.Order.class)
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal shipping;
    @NotNull
    @JsonView(View.Order.class)
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal total;
    @NotNull
    @JsonView(View.Order.class)
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal grandTotal;
    @JsonView(View.Order.class)
    private String firstName;
    @JsonView(View.Order.class)
    private String lastName;
    @JsonView(View.Order.class)
    private String mobile;
    @JsonView(View.Order.class)
    private String line1;
    @JsonView(View.Order.class)
    private String line2;
    @JsonView(View.Order.class)
    private String city;
    @JsonView(View.Order.class)
    private String country;
    @NotNull
    @JsonView(View.Order.class)
    private LocalDate createdAt;
    @JsonView(View.Order.class)
    private LocalDate updatedAt;

    public Order() {
    }

    public Order(Long idOrder, Users users, Status status, @NotNull BigDecimal subTotal,
                @NotNull BigDecimal tax, @NotNull BigDecimal shipping,
                 @NotNull BigDecimal total, @NotNull BigDecimal grandTotal,
                 String firstName, String lastName, String mobile, String line1,
                 String line2, String city,String country, @NotNull LocalDate createdAt,
                 LocalDate updatedAt) {
        this.idOrder = idOrder;
        this.users = users;
        this.status = status;
        this.subTotal = subTotal;
        this.tax = tax;
        this.shipping = shipping;
        this.total = total;
        this.grandTotal = grandTotal;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.country = country;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}

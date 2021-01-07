package com.computerShop.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(schema = "ComputerShop")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrder;
    @ManyToOne
    private Users users;
    private String sessionId;
    private String token;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal subTotal;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal itemDiscount;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal tax;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal shipping;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal total;
    private String promo;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal discount;
    @NotNull
    @Column(columnDefinition = "FLOAT default 0")
    private BigDecimal grandTotal;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private String email;
    private String line1;
    private String line2;
    private String city;
    private String province;
    private String country;
    @NotNull
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Status content;

    public Order() {
    }

    public Order(Long idOrder, Users users, String sessionId, String token, Status status, @NotNull BigDecimal subTotal,
                 @NotNull BigDecimal itemDiscount, @NotNull BigDecimal tax, @NotNull BigDecimal shipping,
                 @NotNull BigDecimal total, String promo, @NotNull BigDecimal discount, @NotNull BigDecimal grandTotal,
                 String firstName, String middleName, String lastName, String mobile, String email, String line1,
                 String line2, String city, String province, String country, @NotNull LocalDate createdAt,
                 LocalDate updatedAt, Status content) {
        this.idOrder = idOrder;
        this.users = users;
        this.sessionId = sessionId;
        this.token = token;
        this.status = status;
        this.subTotal = subTotal;
        this.itemDiscount = itemDiscount;
        this.tax = tax;
        this.shipping = shipping;
        this.total = total;
        this.promo = promo;
        this.discount = discount;
        this.grandTotal = grandTotal;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.province = province;
        this.country = country;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.content = content;
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public BigDecimal getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(BigDecimal itemDiscount) {
        this.itemDiscount = itemDiscount;
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

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public Status getContent() {
        return content;
    }

    public void setContent(Status content) {
        this.content = content;
    }
}

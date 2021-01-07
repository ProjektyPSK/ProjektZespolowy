package com.computerShop.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(schema = "ComputerShop")
public class Transaction {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTransaction;
    @ManyToOne
    @NotNull
    private Users users;
    @NotNull
    @ManyToOne
    private Order order;
    @NotNull
    private String code;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type type;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Mode mode;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String content;


    public Transaction(@NotNull Long idTransaction, @NotNull Users users, @NotNull Order order, @NotNull String code,
                       @NotNull Type type, @NotNull Mode mode, @NotNull Status status, @NotNull LocalDate createdAt,
                       LocalDate updatedAt, String content) {
        this.idTransaction = idTransaction;
        this.users = users;
        this.order = order;
        this.code = code;
        this.type = type;
        this.mode = mode;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.content = content;
    }

    public Transaction() {
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

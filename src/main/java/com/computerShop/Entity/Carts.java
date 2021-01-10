package com.computerShop.Entity;

import javax.persistence.*;

@Entity
@Table(schema = "ComputerShop")
public class Carts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarts;
    private Long idUser;
    private Long idProduct;

    public Carts(Long idCarts, Long idUser, Long idProduct) {
        this.idCarts = idCarts;
        this.idUser = idUser;
        this.idProduct = idProduct;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Carts() {
    }

    public Long getIdCarts() {
        return idCarts;
    }

    public void setIdCarts(Long idCarts) {
        this.idCarts = idCarts;
    }
}

package com.computerShop.Entity;

import com.computerShop.Utils.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(schema = "ComputerShop")
public class Carts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView({View.Cart.class})
    private Long idCarts;
    private Long idUser;
    @ManyToOne
    @JoinColumn(referencedColumnName = "idProduct")
    private Product product;

    public Carts(Long idCarts, Long idUser, Product idProduct) {
        this.idCarts = idCarts;
        this.idUser = idUser;
        this.product = idProduct;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Carts() {
    }

    public Long getIdCarts() {
        return idCarts;
    }

    public void setIdCarts(Long idCarts) {
        this.idCarts = idCarts;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product idProduct) {
        this.product = idProduct;
    }
}

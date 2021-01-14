package com.computerShop.controllers;

import com.computerShop.Entity.Product;
import com.computerShop.Entity.Users;
import com.computerShop.Utils.View;
import com.computerShop.services.CartsService;
import com.computerShop.services.UsersService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;

@RestController
public class CartsController {

    @Autowired
    private CartsService cartsService;

    @Autowired
    private UsersService usersService;


    @PostMapping(value = "/carts/add/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addToCart(@PathVariable Long id, Principal principal) {
        Users currentUser = usersService.getCurrentUser(principal.getName());
        cartsService.addToCart(id,currentUser.getIdUser());
    }

    @PostMapping(value = "/carts/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeFromTheCart(@PathVariable Long id, Principal principal) {
        Users currentUser = usersService.getCurrentUser(principal.getName());
        cartsService.removeFromTheCart(id, currentUser.getIdUser());
    }

    @JsonView(View.Cart.class)
    @GetMapping(value = "/carts",produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Product> viewCart(Authentication authentication, Principal principal) {
        Users currentUser = usersService.getCurrentUser(principal.getName());
        return cartsService.viewCart(currentUser);
    }
}

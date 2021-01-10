package com.computerShop.controllers;

import com.computerShop.Entity.Carts;
import com.computerShop.Entity.Product;
import com.computerShop.Entity.Users;
import com.computerShop.services.CartsService;
import com.computerShop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class CartsController {

    @Autowired
    private CartsService cartsService;

    @Autowired
    private UsersService usersService;


    @PostMapping("/carts/add/{idProduct}")
    public void addToCart(@PathVariable Long idProduct, Principal principal) {
        Users currentUser = usersService.getCurrentUser(principal.getName());
        cartsService.addToCart(idProduct,currentUser.getIdUser());
    }

    @PostMapping("/carts/delete/{idProduct}")
    public void removeFromTheCart(@PathVariable Long idProduct, Principal principal) {
        Users currentUser = usersService.getCurrentUser(principal.getName());
        cartsService.removeFromTheCart(idProduct, currentUser.getIdUser());
    }

    @PostMapping("/carts")
    public List<Product> viewCart(Authentication authentication, Principal principal) {
        Users currentUser = usersService.getCurrentUser(principal.getName());
        return cartsService.viewCart(currentUser);
    }
}

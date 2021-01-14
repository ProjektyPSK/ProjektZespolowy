package com.computerShop.services;

import com.computerShop.Entity.Carts;
import com.computerShop.Entity.Product;
import com.computerShop.Entity.Users;
import com.computerShop.repository.CartsRepository;
import com.computerShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartsService {

    @Autowired
    private CartsRepository cartsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsersService usersService;

    public void addToCart(Long idProduct, Long idUser) {
        Optional<Product> byId = productRepository.findById(idProduct);
        Carts carts = new Carts();
        carts.setProduct(byId.get());
        carts.setIdUser(idUser);
        cartsRepository.save(carts);

    }

    public void removeFromTheCart(Long idCart, Long idUser) {
        Carts carts = cartsRepository.findByIdCartsAndIdUser(idCart,idUser);
        cartsRepository.delete(carts);
    }

    public Set<Product> viewCart(Users users) {
        List<Carts> byIdUser = cartsRepository.findByIdUser(users.getIdUser());
        Set<Product> products = new HashSet<>();

        for (Carts cart: byIdUser){
            Optional<Product> product = productRepository.findById(cart.getProduct().getIdProduct());
            if(product.isPresent()){
                products.add(product.get());
            }
        }


        return products;
    }


}

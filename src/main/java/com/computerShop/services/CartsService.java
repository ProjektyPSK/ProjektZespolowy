package com.computerShop.services;

import com.computerShop.Entity.Carts;
import com.computerShop.Entity.Product;
import com.computerShop.Entity.Users;
import com.computerShop.repository.CartsRepository;
import com.computerShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartsService {

    @Autowired
    private CartsRepository cartsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsersService usersService;

    public void addToCart(Long idProduct, Long idUser) {
        Carts carts = new Carts();
        carts.setIdProduct(idProduct);
        carts.setIdUser(idUser);
        cartsRepository.save(carts);
    }

    public void removeFromTheCart(Long idProduct, Long idUser) {
        Carts byIdUserAndIdProduct = cartsRepository.findByIdUserAndIdProduct(idUser, idProduct);
        cartsRepository.delete(byIdUserAndIdProduct);
    }

    public List<Product> viewCart(Users users) {
        List<Carts> byIdUser = cartsRepository.findByIdUser(users.getIdUser());
        List<Product> products = new ArrayList<>();

        for (Carts cart: byIdUser){
            Optional<Product> product = productRepository.findById(cart.getIdProduct());
            if(product.isPresent()){
                products.add(product.get());
            }
        }


        return products;
    }


}

package com.computerShop.repository;

import com.computerShop.Entity.Carts;
import com.computerShop.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartsRepository extends JpaRepository<Carts, Long> {

    List<Carts> findByIdUser(Long idUser);
    Carts findByIdUserAndIdProduct(Long idUser, Long idProduct);
}

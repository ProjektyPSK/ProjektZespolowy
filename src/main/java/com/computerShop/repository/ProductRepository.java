package com.computerShop.repository;

import com.computerShop.Entity.Carts;
import com.computerShop.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByCarts(Carts carts);

    List<Product> findAllByTitleLike(String title);

    @Query("SELECT p FROM Product p WHERE UPPER(p.title) LIKE %:title%")
    List<Product> findAllByPartOfTitle(@Param("title") String title);
}

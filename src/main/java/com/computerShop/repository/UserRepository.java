package com.computerShop.repository;

import com.computerShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByToken(String token);

    @Query(value = "SELECT u FROM User u where u.email = ?1 and u.password = ?2 ")
    Optional<User> login(String email,String password);
}

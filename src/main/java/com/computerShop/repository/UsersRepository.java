package com.computerShop.repository;

import com.computerShop.Entity.Credentials;
import com.computerShop.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByCredentials(Credentials byEmailCredentials);

//    Users findByEmail(String email);

}

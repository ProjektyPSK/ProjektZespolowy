package com.computerShop.repository;

import com.computerShop.model.Credentials;
import com.computerShop.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByCredentials(Credentials byEmailCredentials);

}

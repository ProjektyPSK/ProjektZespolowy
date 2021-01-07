package com.computerShop.services;

import com.computerShop.model.Credentials;
import com.computerShop.model.Users;
import com.computerShop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    Users createNewUser(){
        Users users = new Users();
        return users;
    }

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

//    public Optional<org.springframework.security.core.userdetails.User> findByToken(String token) {
//        Optional<Users> customer= usersRepository.findByToken(token);
//        if(customer.isPresent()){
//            Users customer1 = customer.get();
//            org.springframework.security.core.userdetails.User user;
//            if(customer1.isAdmin()){
//                user = new org.springframework.security.core.userdetails.User(customer1.getEmail(), customer1.getPassword(), true, true, true, true,
//                        AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
//            }else if(customer1.isVendor()){
//                user = new org.springframework.security.core.userdetails.User(customer1.getEmail(), customer1.getPassword(), true, true, true, true,
//                        AuthorityUtils.createAuthorityList("ROLE_VENDOR"));
//            }else{
//                user = new org.springframework.security.core.userdetails.User(customer1.getEmail(), customer1.getPassword(), true, true, true, true,
//                        AuthorityUtils.createAuthorityList("ROLE_USER"));
//            }
//            return Optional.of(user);
//        }
//        return  Optional.empty();
//    }

    public Users findById(Long id) {
        Optional<Users> customer= usersRepository.findById(id);
        return customer.orElse(null);
    }

    public Users findByCredentials(Credentials byEmailCredentials) {
        return usersRepository.findByCredentials(byEmailCredentials);
    }

}

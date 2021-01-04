package com.computerShop.services;

import com.computerShop.entity.User;
import com.computerShop.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    User createNewUser(){
        User user = new User();
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<org.springframework.security.core.userdetails.User> findByToken(String token) {
        Optional<User> customer= userRepository.findByToken(token);
        if(customer.isPresent()){
            User customer1 = customer.get();
            org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(customer1.getEmail(), customer1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    public User findById(Long id) {
        Optional<User> customer= userRepository.findById(id);
        return customer.orElse(null);
    }

    public String login(String username, String password) {
        Optional<User> customer = userRepository.login(username,password);
        if(customer.isPresent()){
            String token = UUID.randomUUID().toString();
            User custom= customer.get();
            custom.setToken(token);
            userRepository.save(custom);
            return token;
        }

        return StringUtils.EMPTY;
    }

}

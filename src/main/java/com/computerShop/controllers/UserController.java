package com.computerShop.controllers;

import com.computerShop.entity.User;
import com.computerShop.repository.UserRepository;
import com.computerShop.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @PostMapping("/token")
    public String getToken(@RequestParam("email") final String email, @RequestParam("password") final String password){
        String token= userService.login(email,password);
        if(StringUtils.isEmpty(token)){
            return "no token found";
        }
        return token;
    }


    @GetMapping(value = "/api/users/user/{id}",produces = "application/json")
    public User getUserDetail(@PathVariable Long id){
        return userService.findById(id);
    }

}

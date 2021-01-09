package com.computerShop.controllers;

import com.computerShop.Entity.Credentials;
import com.computerShop.Entity.Users;
import com.computerShop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    @Autowired
    private UsersService usersService;


    @GetMapping("/currentUser")
    public Users currentUser(Authentication authentication, Principal principal) {
        Object principal1 = authentication.getPrincipal();
        Users currentUser = usersService.getCurrentUser(principal.getName());
        return currentUser;
           }
}

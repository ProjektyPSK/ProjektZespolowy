package com.computerShop.controllers;

import com.computerShop.Entity.Users;
import com.computerShop.repository.UsersRepository;
import com.computerShop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;


    @GetMapping(value = "/admin/users/user/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Users getUserDetail(@PathVariable Long id){
        return usersService.findById(id);
    }

    @GetMapping(value = "/api/getAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getUserDetail(){
        return usersService.getAllUsers();
    }

    @PostMapping(value = "/mobilePhone", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addMobilePhone(@RequestParam() String phone, Principal principal){
        usersService.addMobilePhone(phone, principal);
    }

}

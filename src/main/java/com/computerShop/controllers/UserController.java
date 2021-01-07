package com.computerShop.controllers;

import com.computerShop.Entity.Users;
import com.computerShop.repository.UsersRepository;
import com.computerShop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;


    @GetMapping(value = "/admin/users/user/{id}",produces = "application/json")
    public Users getUserDetail(@PathVariable Long id){
        return usersService.findById(id);
    }

    @GetMapping(value = "/api/getAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getUserDetail(){
        return usersService.getAllUsers();
    }




}

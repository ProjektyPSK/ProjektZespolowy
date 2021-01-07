package com.computerShop.controllers;

import com.computerShop.model.Users;
import com.computerShop.repository.UsersRepository;
import com.computerShop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;


//    @PostMapping("/token")
//    public String getToken(@RequestParam("email") final String email, @RequestParam("password") final String password){
//        String token= userService.login(email,password);
//        if(StringUtils.isEmpty(token)){
//            return "no token found";
//        }
//        return token;
//    }


    @GetMapping(value = "/admin/users/user/{id}",produces = "application/json")
    public Users getUserDetail(@PathVariable Long id){
        return usersService.findById(id);
    }

    @GetMapping(value = "/admin/getAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getUserDetail(){
        return usersService.getAllUsers();
    }


}

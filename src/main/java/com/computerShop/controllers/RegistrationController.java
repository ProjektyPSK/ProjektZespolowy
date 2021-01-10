package com.computerShop.controllers;

import com.computerShop.model.RegistrationEmployee;
import com.computerShop.model.RegistrationUser;
import com.computerShop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/admin/signUp")
    @ResponseBody
    public String registerAdmin(@RequestBody RegistrationEmployee registrationEmployee) {
        return usersService.registrationEmployee(registrationEmployee);
    }

    @PostMapping(value = "/users/signUp", produces = "application/json")
    @ResponseBody
    public String registrations(@RequestBody RegistrationUser registrationUser) {
        return usersService.signUpUser(registrationUser);
    }


}

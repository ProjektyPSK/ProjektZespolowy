package com.computerShop.controllers;

import com.computerShop.Entity.Users;
import com.computerShop.model.RegistrationEmployee;
import com.computerShop.model.RegistrationUser;
import com.computerShop.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UsersService usersService;

    @PostMapping(value = "/users/registration")
    public Users registerUser(@ModelAttribute("registrationUser") RegistrationUser registrationUser, BindingResult bindingResult, Model model) {
        return usersService.registerUser(registrationUser);
    }

    @PostMapping(value = "/admin/registrationEmployee")
    public Users registerAdmin(@ModelAttribute("registrationEmployee") RegistrationEmployee registrationEmployee, BindingResult bindingResult, Model model) {
        return usersService.registrationEmployee(registrationEmployee);
    }


}

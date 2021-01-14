package com.computerShop.controllers;

import com.computerShop.Entity.Address;
import com.computerShop.Utils.View;
import com.computerShop.services.AddressService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/address")
    @ResponseBody
    public void addAddress(@RequestBody Address address, Principal principal){
        addressService.addAddress(address, principal);
    }

}

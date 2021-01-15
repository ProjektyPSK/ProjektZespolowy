package com.computerShop.controllers;

import com.computerShop.Entity.Address;
import com.computerShop.Utils.View;
import com.computerShop.services.AddressService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/address", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@ModelAttribute Address address, Principal principal){
        addressService.addAddress(address, principal);
    }

}

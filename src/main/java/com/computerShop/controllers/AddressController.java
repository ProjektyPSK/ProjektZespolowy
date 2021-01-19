package com.computerShop.controllers;

import com.computerShop.Entity.Address;
import com.computerShop.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/address", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@ModelAttribute Address address, Principal principal) {
        addressService.addAddress(address, principal);
    }

}

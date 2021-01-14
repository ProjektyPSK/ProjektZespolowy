package com.computerShop.services;

import com.computerShop.Entity.Address;
import com.computerShop.Entity.Users;
import com.computerShop.repository.AddressRepository;
import com.computerShop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    public void addAddress(Address address, Principal principal) {
        Users currentUser = usersService.getCurrentUser(principal.getName());
        address = addressRepository.save(address);
        currentUser.setAddress(address);
        usersRepository.save(currentUser);
    }
}

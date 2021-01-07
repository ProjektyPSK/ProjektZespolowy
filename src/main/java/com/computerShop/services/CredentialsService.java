package com.computerShop.services;

import com.computerShop.Entity.Credentials;
import com.computerShop.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialsService {

    @Autowired
    private CredentialsRepository credentialsRepository;

    public Credentials findByEmail(String email) {
        return credentialsRepository.findByEmail(email);
    }

}

package com.computerShop.services;

import com.computerShop.Entity.Credentials;
import com.computerShop.Entity.Users;
import com.computerShop.model.RegistrationEmployee;
import com.computerShop.model.RegistrationUser;
import com.computerShop.repository.CredentialsRepository;
import com.computerShop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private CredentialsRepository credentialsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users findById(Long id) {
        Optional<Users> customer = usersRepository.findById(id);
        return customer.orElse(null);
    }

    public Users findByCredentials(Credentials byEmailCredentials) {
        return usersRepository.findByCredentials(byEmailCredentials);
    }

    public Users registerUser(RegistrationUser registrationUser) {

        Credentials credential = new Credentials();
        credential.setEmail(registrationUser.getEmail());
        credential.setPassword(passwordEncoder.encode(registrationUser.getPassword()));

        credential = credentialsRepository.save(credential);

        Users user = new Users();
        user.setFirstName(registrationUser.getFirstName());
        user.setMiddleName(registrationUser.getMiddleName());
        user.setLastName(registrationUser.getLastName());
        user.setMobile(registrationUser.getMobile());
        user.setRegistered(LocalDate.now());
        user.setCredentials(credential);
        user.setAdmin(false);
        user.setVendor(false);

        user = usersRepository.save(user);

        return user;
    }

    public Users registrationEmployee(RegistrationEmployee registrationEmployee) {

        Credentials credential = new Credentials();
        credential.setEmail(registrationEmployee.getEmail());
        credential.setPassword(passwordEncoder.encode(registrationEmployee.getPassword()));

        credential = credentialsRepository.save(credential);

        Users user = new Users();
        user.setFirstName(registrationEmployee.getFirstName());
        user.setMiddleName(registrationEmployee.getMiddleName());
        user.setLastName(registrationEmployee.getLastName());
        user.setMobile(registrationEmployee.getMobile());
        user.setRegistered(LocalDate.now());
        user.setCredentials(credential);
        user.setAdmin(registrationEmployee.isAdmin());
        user.setVendor(registrationEmployee.isVendor());

        user = usersRepository.save(user);

        return user;
    }
}

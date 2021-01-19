package com.computerShop.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.computerShop.Entity.Credentials;
import com.computerShop.Entity.Users;
import com.computerShop.model.RegistrationEmployee;
import com.computerShop.model.RegistrationUser;
import com.computerShop.repository.CredentialsRepository;
import com.computerShop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private UsersRepository usersRepository;
    private CredentialsRepository credentialsRepository;
    private PasswordEncoder passwordEncoder;

    private final long expirationTime;
    private final String secret;

    public UsersService(UsersRepository usersRepository, CredentialsRepository credentialsRepository,
                        PasswordEncoder passwordEncoder, @Value("${jwt.expirationTime}") long expirationTime,
                        @Value("${jwt.secret}") String secret) {
        this.usersRepository = usersRepository;
        this.credentialsRepository = credentialsRepository;
        this.passwordEncoder = passwordEncoder;
        this.expirationTime = expirationTime;
        this.secret = secret;
    }


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

    public String registrationEmployee(RegistrationEmployee registrationEmployee) {

        Credentials byEmail = credentialsRepository.findByEmail(registrationEmployee.getEmail());
        Credentials credential = new Credentials();
        Users user = new Users();

        if (byEmail != null) {
            throw new RuntimeException("User already exist.");
        } else {
            credential.setEmail(registrationEmployee.getEmail());
            credential.setPassword(passwordEncoder.encode(registrationEmployee.getPassword()));
            credential = credentialsRepository.save(credential);

            user.setFirstName(registrationEmployee.getFirstName());
            user.setLastName(registrationEmployee.getLastName());
            user.setMobile(registrationEmployee.getMobile());
            user.setRegistered(LocalDate.now());
            user.setCredentials(credential);

            user = usersRepository.save(user);
        }
        return JWT.create()
                .withSubject(user.getCredentials().getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC256(secret));
    }

    public Users getCurrentUser(String users) {
        Credentials byEmail = credentialsRepository.findByEmail(users);
        Users byCredentials = usersRepository.findByCredentials(byEmail);
        return byCredentials;
    }

    public String signUpUser(RegistrationUser user) {

        Credentials byEmail = credentialsRepository.findByEmail(user.getEmail());
        Users customer = new Users();
        Credentials credential = new Credentials();
        if (byEmail != null) {
            throw new RuntimeException("User already exist.");
        } else {

            credential.setEmail(user.getEmail());
            credential.setPassword(passwordEncoder.encode(user.getPassword()));
            credential = credentialsRepository.save(credential);

            customer.setFirstName(user.getFirstName());
            customer.setLastName(user.getLastName());
            customer.setMobile(user.getMobile());
            customer.setRegistered(LocalDate.now());
            customer.setCredentials(credential);
            customer = usersRepository.save(customer);

        }

        return JWT.create()
                .withSubject(customer.getCredentials().getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC256(secret));
    }

    public void addMobilePhone(String phone, Principal principal) {
        Users currentUser = getCurrentUser(principal.getName());
        currentUser.setMobile(phone);
        usersRepository.save(currentUser);
    }
}

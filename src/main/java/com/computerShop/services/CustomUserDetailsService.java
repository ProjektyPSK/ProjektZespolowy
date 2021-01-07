package com.computerShop.services;

import com.computerShop.model.Credentials;
import com.computerShop.model.FrontUserDetail;
import com.computerShop.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private CredentialsService credentialsService;

    @Autowired
    private UsersService usersService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Credentials byEmailCredentials = credentialsService.findByEmail(s);

        if (byEmailCredentials == null) {
            throw new UsernameNotFoundException("Not Exist");
        } else {

        }
        Users byCredentials = usersService.findByCredentials(byEmailCredentials);
        FrontUserDetail frontUserDetail = new FrontUserDetail(byCredentials);
        return frontUserDetail;
    }
}

package com.computerShop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(schema = "ComputerShop")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Credentials credentials;
    private String firstName;
    private String middleName;
    private String lastName;
    private String mobile;
    private boolean isAdmin;
    private boolean isVendor;
    @NotNull
    private LocalDate registered;
    private LocalDate lastLogin;

    public Users(Long idUser, @NotNull Credentials credentials, String firstName, String middleName, String lastName, String mobile, boolean isAdmin,
                 boolean isVendor, LocalDate registered, LocalDate lastLogin) {

        this.idUser = idUser;
        this.credentials = credentials;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.isAdmin = isAdmin;
        this.isVendor = isVendor;
        this.registered = registered;
        this.lastLogin = lastLogin;

    }

    public Users() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isVendor() {
        return isVendor;
    }

    public void setVendor(boolean vendor) {
        isVendor = vendor;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}

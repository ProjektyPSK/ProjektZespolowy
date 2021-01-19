package com.computerShop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(schema = "ComputerShop")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long idUser;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Credentials credentials;
    private String firstName;
    private String lastName;
    private String mobile;
    @NotNull
    private LocalDate registered;
    @OneToOne
    private Address address;

    public Users(Long idUser, @NotNull Credentials credentials, String firstName, String lastName, String mobile,
                 LocalDate registered, Address address) {

        this.idUser = idUser;
        this.credentials = credentials;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.registered = registered;

        this.address = address;
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

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

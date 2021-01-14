package com.computerShop.Entity;

import com.computerShop.Utils.View;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(schema = "ComputerShop")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long idAddress;
    private String city;
    private String country;
    private String street;
    @Column(length = 6)
    private String postCode;
    private String houseNumber;
    private String apartmentNumber;
    @OneToOne
    @JsonIgnore
    private Users users;

    public Address(Long idAddress, String city, String country, String street, String postCode, String houseNumber,
                   String apartmentNumber, Users users) {
        this.idAddress = idAddress;
        this.city = city;
        this.country = country;
        this.street = street;
        this.postCode = postCode;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.users = users;
    }

    public Address() {
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

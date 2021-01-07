package com.computerShop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "ComputerShop")
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long idCredential;
    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String password;

    public Credentials(Long idCredential, @NotNull String email, @NotNull String password) {
        this.idCredential = idCredential;
        this.email = email;
        this.password = password;
    }

    public Credentials() {
    }

    public Long getIdCredential() {
        return idCredential;
    }

    public void setIdCredential(Long idCredential) {
        this.idCredential = idCredential;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.rezende.learn.dto;

import com.rezende.learn.entities.User;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserDTO {

    private UUID id;
    private String firstname;
    private String lastname;
    private String phone;
    private LocalDate birthDate;
    private String email;

    private final Set<RoleDTO> roles = new HashSet<>();

    public UserDTO() {}

    private UserDTO(UUID id, String firstname, String lastname, String phone, LocalDate birthDate, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.birthDate = birthDate;
        this.email = email;
    }

    public static UserDTO from(
            UUID id,
            String firstname,
            String lastname,
            String phone,
            LocalDate birthDate,
            String email) {
        return new UserDTO(id, firstname, lastname, phone, birthDate, email);
    }

    public static UserDTO of(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getBirthDate(),
                user.getEmail());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }
}
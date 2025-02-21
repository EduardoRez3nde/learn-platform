package com.rezende.learn.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "id.user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Like> likes = new HashSet<>();

    @OneToMany(mappedBy = "id.user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Favorite> favorites = new HashSet<>();

    @OneToMany(mappedBy = "id.user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<WatchTime> watchTimes = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private final Set<Role> roles = new HashSet<>();

    public User() { }

    private User(
            UUID id,
            String firstName,
            String lastName,
            String email,
            String phone,
            String password,
            LocalDate birthDate
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.birthDate = birthDate;
    }

    public static User from(
            UUID id,
            String firstName,
            String lastName,
            String email,
            String phone,
            String password,
            LocalDate birthDate
    ) {
        return new User(id, firstName, lastName, email, phone, password, birthDate);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public Set<WatchTime> getWatchTimes() {
        return watchTimes;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}

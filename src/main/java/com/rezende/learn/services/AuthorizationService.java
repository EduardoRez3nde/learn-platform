package com.rezende.learn.services;

import com.rezende.learn.entities.Role;
import com.rezende.learn.entities.User;
import com.rezende.learn.repositories.UserRepository;
import com.rezende.learn.repositories.projections.UserDetailsProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        List<UserDetailsProjection> login = userRepository.findByUsername(username);

        if (login.isEmpty())
            throw new UsernameNotFoundException("User not found");

        Set<Role> roles = login.stream().map(authority ->
                Role.from(authority.getRoleId(), authority.getAuthority())).collect(Collectors.toSet());

        return User.from(login.getFirst().getUsername(), login.getFirst().getPassword(), roles);
    }
}

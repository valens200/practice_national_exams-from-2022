package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.response.LoginResponseDTO;
import com.templates.valens.v1.models.*;
import com.templates.valens.v1.security.User.UserSecurityDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class ServiceImpl {

    public User user;
    public Role role;
    public Product product;
    public Quantity quantity;
    public Customer customer;
    public Cart cat;
    public LoginResponseDTO loginResponseDTO;
    public Optional<Role> roleOptional;

    public Set<Role> roles;
    public UserSecurityDetails userSecurityDetails;
    public List<GrantedAuthority> authorities;

}

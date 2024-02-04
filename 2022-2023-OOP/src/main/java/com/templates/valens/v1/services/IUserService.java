package com.templates.valens.v1.services;

import com.templates.valens.v1.dtos.requests.CreateUserDTO;
import com.templates.valens.v1.models.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    public User createAdmin(CreateUserDTO dto);

    User getById(UUID id);

    List<User> getAll();
}

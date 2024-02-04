package com.templates.valens.v1.services;

import com.templates.valens.v1.models.Role;

import java.util.Optional;

public interface IRoleService {

    public Role findByName(String name);
}

package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.exceptions.NotFoundException;
import com.templates.valens.v1.models.Role;
import com.templates.valens.v1.repositories.IRoleRepository;
import com.templates.valens.v1.services.IRoleService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl implements IRoleService {

    private final IRoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        try {
            return roleRepository.findByRoleName(name).orElseThrow(()->new NotFoundException("The role with the provided name is not found"));
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
}

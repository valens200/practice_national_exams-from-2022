package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.requests.CreateUserDTO;
import com.templates.valens.v1.exceptions.BadRequestException;
import com.templates.valens.v1.exceptions.NotFoundException;
import com.templates.valens.v1.models.User;
import com.templates.valens.v1.repositories.IUserRepository;
import com.templates.valens.v1.services.IRoleService;
import com.templates.valens.v1.services.IUserService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import com.templates.valens.v1.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final IRoleService roleService;

    @Value("${app.admin.key}")
    private String adminKey;
    @Override
    public User createAdmin(CreateUserDTO dto) {
        try {
            if(!adminKey.equals(dto.getAdminKey())) throw new BadRequestException("You are not authorized to create an admin");
            if(dto.getPassword().equals("") || dto.getEmail().equals("")) throw new BadRequestException("The email and password inputs are required");
            if(userRepository.existsByEmail(dto.getEmail())) throw  new BadRequestException("The user with the provided email already exist, please login");
            user = new User(dto.getEmail(),dto.getUserName(), SecurityUtils.HashString(dto.getPassword()));
            role = this.roleService.findByName("ADMIN");
            roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            return this.userRepository.save(user);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
    @Override
    public User getById(UUID id){
        return userRepository.findById(id).orElseThrow(()-> new NotFoundException("The user with the provided id is not found"));
    }

    @Override
    public List<User> getAll() {
        try {
            return this.userRepository.findAll();
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }
}

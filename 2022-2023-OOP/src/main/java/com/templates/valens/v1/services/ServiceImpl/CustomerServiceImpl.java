package com.templates.valens.v1.services.ServiceImpl;

import com.templates.valens.v1.dtos.requests.CreateCustomerDTO;
import com.templates.valens.v1.exceptions.ForbiddenException;
import com.templates.valens.v1.models.Customer;
import com.templates.valens.v1.models.Role;
import com.templates.valens.v1.models.User;
import com.templates.valens.v1.models.enums.ERole;
import com.templates.valens.v1.repositories.ICustomerRepository;
import com.templates.valens.v1.repositories.IUserRepository;
import com.templates.valens.v1.services.ICustomerService;
import com.templates.valens.v1.services.IRoleService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import com.templates.valens.v1.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends ServiceImpl implements ICustomerService {
    private  final ICustomerRepository customerRepository;
    private final IUserRepository userRepository;
    private final IRoleService roleService;

   public Customer create(CreateCustomerDTO dto){
       try {
           if(customerRepository.existsByEmail(dto.getEmail())) throw new ForbiddenException("The employee is already registered");
           if(userRepository.existsByEmail(dto.getEmail())) throw new ForbiddenException("The user with the provided email is already registered");
           user = new User();
           user.setUserName(dto.getUserName());
           user.setEmail(dto.getEmail());
           user.setPassword(SecurityUtils.HashString(dto.getPassword()));
           roles = new HashSet<>();
           role =  roleService.findByName(ERole.CUSTOMER.name());
           roles.add(role);
           user.setRoles(roles);
           user = this.userRepository.save(user);
           customer = new Customer();
           customer.setPhone(dto.getPhoneNumber());
           customer.setFirstName(dto.getFirstName());
           customer.setLastName(dto.getLastName());
           customer.setProfile(user);
           return customerRepository.save(customer);
       }catch (Exception exception){
           ExceptionsUtils.handleServiceExceptions(exception);
           return null;
       }

   }
   public Customer update(UUID customerId, CreateCustomerDTO dto){
       try {
           return null;
       }catch (Exception exception){
           ExceptionsUtils.handleServiceExceptions(exception);
           return null;
       }
   }

   public List<Customer> getAll(){
       try {
           return null;
       }catch (Exception exception){
           ExceptionsUtils.handleServiceExceptions(exception);
           return null;
       }

   }
    public Page<Customer> getAllPaginated(){
        try {
            return null;
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }

    }

   public Customer getById(UUID  customerId){
       try {
           return null;
       }catch (Exception exception){
           ExceptionsUtils.handleServiceExceptions(exception);
           return null;
       }

   }

}

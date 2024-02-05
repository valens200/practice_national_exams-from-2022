package com.templates.valens.v1.services.ServiceImpl;
import com.templates.valens.v1.dtos.requests.CreateCustomerDTO;
import com.templates.valens.v1.exceptions.ForbiddenException;
import com.templates.valens.v1.exceptions.NotFoundException;
import com.templates.valens.v1.models.Cart;
import com.templates.valens.v1.models.Customer;
import com.templates.valens.v1.models.User;
import com.templates.valens.v1.models.enums.ERole;
import com.templates.valens.v1.repositories.ICatRepository;
import com.templates.valens.v1.repositories.ICustomerRepository;
import com.templates.valens.v1.repositories.IUserRepository;
import com.templates.valens.v1.services.ICustomerService;
import com.templates.valens.v1.services.IRoleService;
import com.templates.valens.v1.services.IUserService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import com.templates.valens.v1.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends ServiceImpl implements ICustomerService {
    private  final ICustomerRepository customerRepository;
    private final IUserRepository userRepository;
    private final IRoleService roleService;
    private final IUserService userService;
    private final ICatRepository catRepository;

    @Override
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
           customer = customerRepository.save(customer);
           cat = new Cart();
           cat.setCustomer(customer);
           cat = catRepository.save(cat);
           customer.setCat(cat);
           return customerRepository.save(customer);
       }catch (Exception exception){
           ExceptionsUtils.handleServiceExceptions(exception);
           return null;
       }

   }
    @Override
   public Customer update(UUID customerId, CreateCustomerDTO dto){
       try {
           customer = this.getById(customerId);
           user = userRepository.findUserByEmail(dto.getEmail()).orElseThrow(()->new NotFoundException("The user with the provided email is not fund"));
           user.setEmail(dto.getEmail());
           user.setPassword(SecurityUtils.HashString(dto.getPassword()));
           user = this.userRepository.save(user);
           customer.setPhone(dto.getPhoneNumber());
           customer.setLastName(dto.getLastName());
           customer.setFirstName(dto.getFirstName());
           customer.setProfile(user);
           return this.customerRepository.save(customer);
       }catch (Exception exception){
           ExceptionsUtils.handleServiceExceptions(exception);
           return null;
       }
   }

    @Override
   public List<Customer> getAll(){
       try {
           return customerRepository.findAll();
       }catch (Exception exception){
           ExceptionsUtils.handleServiceExceptions(exception);
           return null;
       }

   }

    @Override
    public Page<Customer> getAllPaginated(Pageable pageable){
        try {
            return customerRepository.findAll(pageable);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }

    }

    @Override
   public Customer getById(UUID customerId){
       try {
           return this.customerRepository.findById(customerId).orElseThrow(()->new NotFoundException("The customer with the provided id is not found"));
       }catch (Exception exception){
           ExceptionsUtils.handleServiceExceptions(exception);
           return null;
       }
   }

}

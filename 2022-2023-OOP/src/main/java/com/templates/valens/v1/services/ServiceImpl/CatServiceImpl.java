package com.templates.valens.v1.services.ServiceImpl;
import com.templates.valens.v1.exceptions.NotFoundException;
import com.templates.valens.v1.models.Cart;
import com.templates.valens.v1.models.Quantity;
import com.templates.valens.v1.repositories.ICatRepository;
import com.templates.valens.v1.services.ICatService;
import com.templates.valens.v1.services.ICustomerService;
import com.templates.valens.v1.services.IQuantityService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatServiceImpl extends ServiceImpl implements ICatService {
    private final ICatRepository catRepository;
    private  final ICustomerService customerService;
    private final IQuantityService quantityService;
    private final ICatService catService;

    @Override
    public List<Cart> getAll(){
        try {
            return catRepository.findAll();
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Cart getById(UUID id){
        try {
            return this.catRepository.findById(id).orElseThrow(()->new NotFoundException("The cart with the provided id is not found"));
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Cart getByCustomer(UUID customerId){
        try {
            customer = customerService.getById(customerId);
            return catRepository.findByCustomer(customer);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Cart addQuantity(UUID quantityId, UUID cartId){
        try {
            quantity = quantityService.getById(quantityId);
            cat = catService.getById(cartId);
            Set<Quantity> quantities = cat.getQuantities();
            quantities.add(quantity);
            cat.setQuantities(quantities);
            return catRepository.save(cat);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

    @Override
    public Cart removeQuantity(UUID quantityId, UUID cartId){
        try {
            quantity = quantityService.getById(quantityId);
            cat = catService.getById(cartId);
            Set<Quantity> quantities = cat.getQuantities();
            quantities.remove(quantity);
            cat.setQuantities(quantities);
            return catRepository.save(cat);
        }catch (Exception exception){
            ExceptionsUtils.handleServiceExceptions(exception);
            return null;
        }
    }

}

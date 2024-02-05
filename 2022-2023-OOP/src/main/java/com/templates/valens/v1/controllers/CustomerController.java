package com.templates.valens.v1.controllers;
import com.templates.valens.v1.dtos.requests.CreateCustomerDTO;
import com.templates.valens.v1.payload.ApiResponse;
import com.templates.valens.v1.services.ICustomerService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;

    @PostMapping("create")
    public ResponseEntity<ApiResponse> create(@RequestBody CreateCustomerDTO dto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true,"The customer was created successfully", this.customerService.create(dto)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }

    }

    @PutMapping("update/${customerId}")
    public ResponseEntity<ApiResponse> update(@PathVariable("customerId") UUID customerId, @RequestBody() CreateCustomerDTO dto){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"The customer was updated successfully", this.customerService.update(customerId,dto)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("all")
    public ResponseEntity<ApiResponse> getAll(){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Customers retrieved successfully", this.customerService.getAll()));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("all/paginated")
    public ResponseEntity<ApiResponse> getAllPaginated(Pageable pageable){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Paginated customers retrieved successfully", this.customerService.getAllPaginated(pageable)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse> getById(@PathVariable("customerId") UUID  customerId){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Customer retrieved successfully", this.customerService.getById(customerId)));
        }catch (Exception exception){
           return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

}

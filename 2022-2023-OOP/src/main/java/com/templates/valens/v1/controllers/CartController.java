package com.templates.valens.v1.controllers;
import com.templates.valens.v1.payload.ApiResponse;
import com.templates.valens.v1.services.ICatService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {
    private ICatService catService;

    @GetMapping("all")
    public ResponseEntity<ApiResponse> getAll(){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"All carts retrieved successfully", this.catService.getAll()));
        }catch (Exception exception){
          return   ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable("id") UUID id){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"The cart retrieved successfully", this.catService.getById(id)));
        }catch (Exception exception){
            return   ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("all/by-customer/{customerId}")
    public ResponseEntity<ApiResponse> getByCustomer(@PathVariable("customerId") UUID customerId){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Cart retrieved successfully", this.catService.getByCustomer(customerId)));
        }catch (Exception exception){
            return   ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("/add-quantity")
    public ResponseEntity<ApiResponse> addQuantity(@RequestParam("quantityId") UUID quantityId, @RequestParam("cartId") UUID cartId){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"The quantity was add ress"))
        }catch (Exception exception){
            return   ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("/remove-quant")
    public ResponseEntity<ApiResponse> removeQuantity(UUID quantityId, UUID cartId){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"The quantity removed successfully", this.catService.removeQuantity(quantityId,cartId)));
        }catch (Exception exception){
            return   ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
}

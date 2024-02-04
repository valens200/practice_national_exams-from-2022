package com.templates.valens.v1.controllers;
import com.templates.valens.v1.dtos.requests.CreateQuantityDTO;
import com.templates.valens.v1.payload.ApiResponse;
import com.templates.valens.v1.services.IQuantityService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/quantities")
@RequiredArgsConstructor
public class QuantityController {
    private final IQuantityService quantityService;

    @PostMapping("create")
    public ResponseEntity<ApiResponse> create(@RequestBody() CreateQuantityDTO dto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true,"The quantity created successfully ", this.quantityService.create(dto)));
        }catch (Exception exception){
           return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
    @PutMapping("update")
    public ResponseEntity<ApiResponse> update(UUID quantityId, CreateQuantityDTO dto){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"The quantity updated successfully", this.quantityService.update(quantityId,dto)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("all")
    public ResponseEntity<ApiResponse> getAll(){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Quantities retrieved successfully", this.quantityService.getAll()));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("all/paginated")
    public ResponseEntity<ApiResponse> getAllPaginated(Pageable pageable){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Quantities retrieved successfully", this.quantityService.getAllPaginated(pageable)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }

    }

    @GetMapping("all/by-product")
    public ResponseEntity<ApiResponse> getAllByProduct(@RequestParam("productId") UUID productId){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Quantities retrieved successfully", this.quantityService.getAllByProduct(productId)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
    @GetMapping("all/by-product/paginated")
    public ResponseEntity<ApiResponse> getAllByProductPaginated(@RequestParam("productId") UUID productId, Pageable pageable){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Quantities retrieved successfully", this.quantityService.getAllByProductPaginated(productId,pageable)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable("id") UUID Id){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"The quantity retrieved successfully", this.quantityService.getById(Id)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
}

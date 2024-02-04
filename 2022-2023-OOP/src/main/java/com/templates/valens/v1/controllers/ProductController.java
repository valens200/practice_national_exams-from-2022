package com.templates.valens.v1.controllers;
import com.templates.valens.v1.dtos.requests.CreateProductDTO;
import com.templates.valens.v1.models.enums.EProductType;
import com.templates.valens.v1.payload.ApiResponse;
import com.templates.valens.v1.services.IProductService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    @PostMapping("create")
    public ResponseEntity<ApiResponse> create(@RequestBody() CreateProductDTO dto, @RequestParam("productType") EProductType productType){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true,"The product was created successfully", this.productService.create(dto,productType)));
        }catch (Exception exception){
         return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PutMapping("update/{productId}")
    public ResponseEntity<ApiResponse> update(@PathVariable("productId") UUID productId, @RequestBody() CreateProductDTO dto){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"The product was updated sucessfully", this.productService.update(productId,dto)));
        }catch (Exception exception){
         return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("all")
    public ResponseEntity<ApiResponse> getAll(){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"All products retrieved successfully", this.productService.getAll()));
        }catch (Exception exception){
         return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
    @GetMapping("all/paginated")
    public ResponseEntity<ApiResponse> getAllPaginated(Pageable pageable){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Paginated products retrieved successfully", this.productService.getAllPaginated(pageable)));
        }catch (Exception exception){
             return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getById(UUID id){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"The product retrieved successfully", this.productService.getById(id)));
        }catch (Exception exception){
             return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
}

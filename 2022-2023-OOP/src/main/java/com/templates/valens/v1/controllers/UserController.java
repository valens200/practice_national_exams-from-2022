package com.templates.valens.v1.controllers;
import com.templates.valens.v1.dtos.requests.CreateUserDTO;
import com.templates.valens.v1.payload.ApiResponse;
import com.templates.valens.v1.services.IUserService;
import com.templates.valens.v1.utils.ExceptionsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll(){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"All users retrieved successfully", this.userService.getAll()));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @PostMapping("create")
    public ResponseEntity<ApiResponse> createAdmin(@RequestBody() CreateUserDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true,"The user created successfully", this.userService.createAdmin(dto)));
        }catch (Exception exception){
           return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse> getById(@PathVariable("id") UUID id){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"The user retrieved successfully", this.userService.getById(id)));
        }catch (Exception exception){
            return ExceptionsUtils.handleControllerExceptions(exception);
        }
    }
}

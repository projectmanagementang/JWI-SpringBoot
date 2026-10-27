package com.jspl.JindalWorld.controller;


import com.jspl.JindalWorld.dto.ApiResponse;
import com.jspl.JindalWorld.dto.LoginRequest;
import com.jspl.JindalWorld.dto.LoginResponse;
import com.jspl.JindalWorld.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @RequestBody LoginRequest request
            ){

        System.out.println("LOGIN CONTROLLER REACHED");

        LoginResponse response = authService.login(request);

        return ResponseEntity.ok(
                ApiResponse.success("Login succesfull" , response)
        );
    }





}

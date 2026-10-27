package com.jspl.JindalWorld.service;


import com.jspl.JindalWorld.dto.LoginRequest;
import com.jspl.JindalWorld.dto.LoginResponse;
import com.jspl.JindalWorld.entity.UserAccount;
import com.jspl.JindalWorld.repository.UserAccountRepository;
import com.jspl.JindalWorld.security.JwtService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserAccountRepository userAccountRepository;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest loginRequest) {

        System.out.println("LOGIN SERVICE REACHED");


        // 1. Authenticate the user through Spring Security
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.email(),
                                loginRequest.password()
                        )
                );

        // 2. Retrieve the authenticated user's details
        String email = authentication.getName();

        UserAccount user = userAccountRepository.findByEmail(email)
                .orElseThrow(() ->
                        new BadCredentialsException(
                                "Invalid email or password"
                        )
                );

        // 3. Check account status
        if (!"active".equalsIgnoreCase(user.getStatus())
                || user.getDeletedAt() != null) {
            throw new BadCredentialsException(
                    "Invalid email or password"
            );
        }

        // 4. Generate JWT after successful authentication
        String accessToken = jwtService.generateToken(authentication);

        // 5. Return the login response
        return new LoginResponse(
                accessToken,
                "Bearer"
        );
    }
}



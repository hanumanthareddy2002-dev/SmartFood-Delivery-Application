package com.nit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nit.dto.AuthResponse;
import com.nit.dto.LoginRequest;
import com.nit.dto.RegisterRequest;
import com.nit.entity.Role;
import com.nit.entity.User;
import com.nit.repository.UserRepository;
import com.nit.security.JwtService;



@Service
public class AuthServiceImpl implements AuthService 
{
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
    private JwtService jwtService;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {

            throw new RuntimeException(
                "Email already registered"
            );
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // BCrypt password encryption
        user.setPassword(
            passwordEncoder.encode(request.getPassword())
        );

        user.setPhone(request.getPhone());

        // Every new user gets USER role
        user.setRole(Role.CUSTOMER);

        User savedUser =
                userRepository.save(user);

        String token =
                jwtService.generateToken(savedUser);

        return new AuthResponse(token,"Bearer",savedUser.getId(),savedUser.getEmail(),savedUser.getRole());
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user =
            userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                    new RuntimeException(
                        "Invalid email or password"
                    )
                );

        // Compare normal password with encrypted password
        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException(
                "Invalid email or password"
            );
        }

        String token =
                jwtService.generateToken(user);

        return new AuthResponse(token,"Bearer",user.getId(),user.getEmail(),user.getRole());
    }

	
}
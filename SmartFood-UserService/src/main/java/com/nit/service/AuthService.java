package com.nit.service;

import com.nit.dto.AuthResponse;
import com.nit.dto.LoginRequest;
import com.nit.dto.RegisterRequest;

public interface AuthService {
	AuthResponse register(RegisterRequest request);
	AuthResponse login(LoginRequest request);
	

}

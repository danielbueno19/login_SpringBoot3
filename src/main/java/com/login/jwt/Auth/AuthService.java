package com.login.jwt.Auth;

import org.springframework.stereotype.Service;

import com.login.jwt.Jwt.JwtService;
import com.login.jwt.User.Role;
import com.login.jwt.User.User;
import com.login.jwt.User.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest loginRequest) {
        return null;
    }

    public AuthResponse register(RegisterRequest registerRequest) {

        User user = User.builder()
                        .username(registerRequest.getUsername())
                        .password(registerRequest.getPassword())
                        .firstname(registerRequest.getFirstname())
                        .lastname(registerRequest.getLastname())
                        .contry(registerRequest.getCountry())
                        .role(Role.USER)
                        .build();

        userRepository.save(user);

        return AuthResponse.builder()
                           .token(jwtService.getToken(user))
                           .build();
    }

}

package com.gesthub.gesthub.services;

import com.gesthub.gesthub.controllers.auth.AuthResponse;
import com.gesthub.gesthub.controllers.auth.LoginRequest;
import com.gesthub.gesthub.controllers.auth.RegisterRequest;
import com.gesthub.gesthub.models.User;
import com.gesthub.gesthub.repositories.UserRepository;
import com.gesthub.gesthub.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final UserService userService;
  private final JwtService jwtService;
  public AuthResponse register(RegisterRequest request) {
    User user = User
      .builder()
      .firstname(request.getFirstname())
      .lastname(request.getLastname())
      .email(request.getEmail())
      .password(passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()))
      .build();
    userRepository.save(user);
    String jwtToken = jwtService.generateToken(user);
    return AuthResponse
      .builder()
      .token(jwtToken)
      .build();
  }

  public AuthResponse login(LoginRequest request) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        request.getEmail(),
        request.getPassword()
      )
    );

    User user = (User) userService.loadUserByUsername(request.getEmail());
    String jwtToken = jwtService.generateToken(user);
    return AuthResponse
      .builder()
      .token(jwtToken)
      .build();
  }
}

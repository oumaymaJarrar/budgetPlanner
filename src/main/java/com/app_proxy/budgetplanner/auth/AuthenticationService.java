package com.app_proxy.budgetplanner.auth;

import com.app_proxy.budgetplanner.Config.JwtService;
import com.app_proxy.budgetplanner.Dto.UserDto;
import com.app_proxy.budgetplanner.Entities.User;
import com.app_proxy.budgetplanner.Repository.UserRepository;
import com.app_proxy.budgetplanner.Service.UserService;
import com.app_proxy.budgetplanner.security.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public User register(UserDto request) {
        var user = User.builder()
                .name(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

//        var jwtToken = jwtService.generateToken(user);
        return repository.save(user);
    }
    public User authenticate(UserDto request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
        );
        return repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }

    }


package com.app_proxy.budgetplanner.auth;

import com.app_proxy.budgetplanner.Config.JwtService;
import com.app_proxy.budgetplanner.Dto.UserDto;
import com.app_proxy.budgetplanner.Entities.User;
import com.app_proxy.budgetplanner.Mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserMapper mapper;
    private final JwtService jwtService;
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto request) {
        User registredUser=service.register(request);
    return ResponseEntity.ok(mapper.mapToDto(registredUser));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody UserDto loginUserDto) {
        User authenticatedUser = service.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        AuthenticationResponse loginResponse = new AuthenticationResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

}


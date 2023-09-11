package net.mcoto.app.controllers;

import net.mcoto.app.entities.AppUsers;
import net.mcoto.app.model_response.AuthResponseModel;
import net.mcoto.app.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    final private AuthenticationManager authenticationManager;
    final private JwtTokenProvider jwtTokenProvider;
    @Value("${app.jwt-expiration-milliseconds}")
    private Long expirationTime;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseModel> login(@RequestBody AppUsers appUsers) {
        final AuthResponseModel authResponseModel;
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUsers.getUserName(), appUsers.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        authResponseModel = new AuthResponseModel(
                HttpStatus.OK.value(),
                "Successfully logged in",
                token,
                System.currentTimeMillis(),
                expirationTime
        );
        return ResponseEntity.ok(authResponseModel);
    }
}

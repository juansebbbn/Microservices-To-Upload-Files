package com.juan.authmicroservice.controllers;

import com.juan.authmicroservice.models.dtos.LoginDTO;
import com.juan.authmicroservice.models.dtos.RegisterDTO;
import com.juan.authmicroservice.models.responses.AuthResponse;
import com.juan.authmicroservice.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterDTO reg) {
        try {
            AuthResponse response = authService.register(reg);
            return ResponseEntity.ok(response); // HTTP 200
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest() // HTTP 400
                    .body(new AuthResponse(reg.getUsername(), e.getMessage(), " ", " ", false));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest() // HTTP 400
                    .body(new AuthResponse(reg.getUsername(), e.getMessage(), " ", " ", false));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) // HTTP 500
                    .body(new AuthResponse(reg.getUsername(), "Error interno del servidor", " ", " ", false));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO log){

        try {
            AuthResponse response = authService.login(log);
            return ResponseEntity.ok(response); // HTTP 200
        }catch (RuntimeException e){
            return ResponseEntity.badRequest() // HTTP 400
                    .body(new AuthResponse(log.getUsername(), e.getMessage(), " ", " ", false));
        }

    }

}

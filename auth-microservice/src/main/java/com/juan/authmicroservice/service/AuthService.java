package com.juan.authmicroservice.service;

import com.juan.authmicroservice.models.User;
import com.juan.authmicroservice.models.dtos.LoginDTO;
import com.juan.authmicroservice.models.dtos.RegisterDTO;
import com.juan.authmicroservice.models.enums.Role;
import com.juan.authmicroservice.models.responses.AuthResponse;
import com.juan.authmicroservice.repos.UserRepo;
import io.jsonwebtoken.Jwt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthService {

    private UserRepo userRep;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    public AuthService(UserRepo userRep, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.userRep = userRep;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterDTO reg) {
        User userDb = userRep.findByusername(reg.getUsername());

        if(userDb != null){
            throw new RuntimeException("El usuario ya existe");
        }

        if(reg.getUsername().length() <= 6){
            throw new IllegalArgumentException("El nombre de usuario es demasiado corto");
        }

        if(reg.getPswd().length() <= 6){
            throw new IllegalArgumentException("La contraseña de usuario es demasiado corto");
        }

        String pswd = passwordEncoder.encode(reg.getPswd());

        User user = new User(reg.getUsername(), pswd, reg.getRole());

        userRep.save(user);

        return new AuthResponse(user.getUsername(), "Usuario creado con exito, proceda a logearse", " ", user.getRol() ,true);
    }

    public AuthResponse login(LoginDTO log) {
        User userDb = userRep.findByusername(log.getUsername());

        if(userDb == null){
            throw new RuntimeException("El usuario no existe, registrese");
        }

        if (!passwordEncoder.matches(log.getPswd(), userDb.getPswd())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtService.generateToken(userDb.getUsername(),  userDb.getRol());

        return new AuthResponse(userDb.getUsername(), "Usuario logeado", token, userDb.getRol(),true);
    }
}

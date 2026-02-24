package com.juan.authmicroservice.models.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthResponse {
    private String user;
    private String mensaje;
    private String token;
    private String role;
    private boolean exito;
}

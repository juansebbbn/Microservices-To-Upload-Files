package com.juan.authmicroservice.models.dtos;

import com.juan.authmicroservice.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RegisterDTO {
    private String username;
    private String pswd;
    private Role role;
}

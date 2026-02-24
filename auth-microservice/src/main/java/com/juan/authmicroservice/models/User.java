package com.juan.authmicroservice.models;

import com.juan.authmicroservice.models.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String pswd;
    private Enum<Role> rol;

    public User(String username, String pswd, Role role) {
        this.username = username;
        this.pswd = pswd;
        this.rol = role;
    }

    public String getRol() {
        return rol.name();
    }
}

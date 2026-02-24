package com.juan.authmicroservice.repos;

import com.juan.authmicroservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByusername(String user);
}

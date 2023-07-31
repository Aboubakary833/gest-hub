package com.gesthub.gesthub.repositories;

import com.gesthub.gesthub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

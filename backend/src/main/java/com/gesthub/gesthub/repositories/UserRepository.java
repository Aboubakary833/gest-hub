package com.gesthub.gesthub.repositories;

import com.gesthub.gesthub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, UUID> {
  Optional <User> findByEmail(String email);
}

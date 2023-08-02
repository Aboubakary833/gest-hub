package com.gesthub.gesthub.controllers.auth;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  @Valid

  private static final String NOT_NULL_MESSAGE = "Ce champ est obligatoire.";
  private static final String NOT_EMAIL_MESSAGE = "L'adresse email fourni est invalide.";
  private static final String INVALID_PASSWORD_MESSAGE = "Vous devez fournir entre 8 et 16 caractères.";

  @NotNull(message = NOT_NULL_MESSAGE)
  private String firstname;
  @NotNull(message = NOT_NULL_MESSAGE)
  private String lastname;
  @NotNull(message = NOT_NULL_MESSAGE)
  @Email(message = NOT_EMAIL_MESSAGE)
  private String email;
  @NotNull(message = NOT_NULL_MESSAGE)
  @Email(message = NOT_NULL_MESSAGE)
  private String password;
}

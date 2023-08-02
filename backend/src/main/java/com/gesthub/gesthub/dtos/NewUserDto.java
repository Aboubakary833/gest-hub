package com.gesthub.gesthub.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NewUserDto {

  @Valid

  private static final String NotNullMessage = "Ce champ est obligatoire.";
  private static final String EmailMessage = "L'adresse email fourni est invalide.";
  private static final String PasswordMessage = "Vous devez fournir entre 8 et 16 caractères.";

  @NotNull(message = NotNullMessage)
  public String firstname;
  @NotNull(message = NotNullMessage)
  public String lastname;
  @NotNull(message = NotNullMessage)
  @Email(message = EmailMessage)
  public String email;
  @NotNull(message = NotNullMessage)
  @Size(min = 8, max = 16, message = PasswordMessage)
  public String password;

  public NewUserDto() {
  }

  public NewUserDto(String firstname, String lastname, String email, String password) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
  }
}

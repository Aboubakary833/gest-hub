package com.gesthub.gesthub.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "User")
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(
    name = "id",
    updatable = false
  )
  private UUID id;

  @Column(
    name = "firstname",
    columnDefinition = "varchar(255)",
    nullable = false
  )
  public String firstname;

  @Column(
    name = "lastname",
    columnDefinition = "varchar(255)",
    nullable = false
  )
  public String lastname;

  @Column(
    name = "email",
    columnDefinition = "varchar(255)",
    nullable = false,
    unique = true
  )
  public String email;

  @Column(
    name = "avatar",
    columnDefinition = "varchar(255)",
    nullable = false
  )
  public String avatar;

  @Column(
    name = "password",
    columnDefinition = "varchar(255)",
    nullable = false
  )
  private String password;

  public User() {
  }

  public User(String firstname, String lastname, String email, String avatar, String password) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.avatar = avatar;
    this.password = password;
  }

  public UUID getId() {
    return this.id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getPassword() {
    return password;
  }
}

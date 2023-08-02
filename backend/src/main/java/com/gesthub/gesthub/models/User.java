package com.gesthub.gesthub.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity(name = "User")
@Table(name = "users")
public class User implements UserDetails {
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
  private String firstname;

  @Column(
    name = "lastname",
    columnDefinition = "varchar(255)",
    nullable = false
  )
  private String lastname;

  @Column(
    name = "email",
    columnDefinition = "varchar(255)",
    nullable = false,
    unique = true
  )
  private String email;

  @Column(
    name = "avatar",
    columnDefinition = "varchar(255) default avatar.png",
    nullable = false
  )
  private String avatar = "avatar.png";

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

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }

  @OneToMany(mappedBy = "user")
  public List<Photo> photos;

  @OneToMany(mappedBy = "author")
  public List<Comment> comments;

  @OneToMany(mappedBy = "author")
  public List<Like> likes;
}

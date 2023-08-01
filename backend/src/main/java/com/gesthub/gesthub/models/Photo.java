package com.gesthub.gesthub.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "Photo")
@Table(name = "photos")
public class Photo {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(
    name = "id",
    updatable = false
  )
  private UUID id;

  @Column(
    name = "url",
    columnDefinition = "varchar(255)",
    nullable = false
  )
  public String url;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "photo")
  public List<Comment> comments;

  @OneToMany(mappedBy = "photo")
  public List<Like> likes;

  public Photo() {
  }

  public Photo(String url, User user) {
    this.url = url;
    this.user = user;
  }

  public UUID getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}

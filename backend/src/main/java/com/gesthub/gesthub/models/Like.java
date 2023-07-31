package com.gesthub.gesthub.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "Like")
@Table(name = "likes")
public class Like {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(
    name = "id",
    updatable = false
  )
  private UUID id;

  @OneToOne
  @JoinColumn(name="author_id")
  public User author;

  @OneToOne
  @JoinColumn(name="photo_id")
  public Photo photo;

  public Like() {
  }

  public Like(User author, Photo photo) {
    this.author = author;
    this.photo = photo;
  }

  public UUID getId() {
    return id;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public Photo getPhoto() {
    return photo;
  }

  public void setPhoto(Photo photo) {
    this.photo = photo;
  }
}

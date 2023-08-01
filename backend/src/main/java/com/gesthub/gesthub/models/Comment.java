package com.gesthub.gesthub.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "Comment")
@Table(name = "comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(
    name = "id",
    updatable = false
  )
  private UUID id;

  @ManyToOne
  @JoinColumn(name="author_id")
    public User author;

  @ManyToOne
  @JoinColumn(name="photo_id")
  public Photo photo;

  @Column(
    name = "text",
    nullable = false
  )
  @Lob
  public String text;

  public Comment() {
  }

  public Comment(User author, Photo photo, String text) {
    this.author = author;
    this.photo = photo;
    this.text = text;
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

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}

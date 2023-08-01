package com.gesthub.gesthub.controllers;

import com.gesthub.gesthub.models.Photo;
import com.gesthub.gesthub.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/photo")
public class PhotoController {

  @GetMapping
  public Photo photo() {
    return new Photo(
      "http://localhost:8080/01.jpg",
      new User(
        "John",
        "Doe",
        "johndoe@gmail.com",
        "avatar.png",
        "john@1234"
      )
    );
  }
}

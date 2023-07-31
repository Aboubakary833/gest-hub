package com.gesthub.gesthub.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  public String home() {
    return "Hello world";
  }
}

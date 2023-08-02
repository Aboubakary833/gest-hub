package com.gesthub.gesthub.controllers;

import com.gesthub.gesthub.ValidationExceptionHandler;
import com.gesthub.gesthub.models.User;

@RestController
@RequestMapping(path = "/api/v1/register")
@AllArgsConstructor
public class RegistrationController extends ValidationExceptionHandler {
  private RegistrationService registrationService;

  @PostMapping
  public ResponseEntity<?> register(@RequestBody User user, @Param("avatar") MultipartFile avatar) {
    return new ResponseEntity(user.getFirstname() + " uploaded file of type" + avatar.getContentType(), HttpStatus.ACCEPTED);
  }
}

package com.backand.tracker.controllers;

import com.backand.tracker.domains.User;
import com.backand.tracker.domains.primitives.EmailAddress;
import com.backand.tracker.domains.primitives.Password;
import com.backand.tracker.dtos.req.AuthReqDto;
import com.backand.tracker.dtos.req.RegistrationReqDto;
import com.backand.tracker.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthRestControllerV1 {
    private final AuthService authService;

    @Autowired
    public AuthRestControllerV1(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthReqDto reqDto) {
        String token = authService.authorization(reqDto.getUsername(), reqDto.getPassword());
        return new ResponseEntity(token, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity signup(@RequestBody RegistrationReqDto reqDto) {
        EmailAddress emailAddress = new EmailAddress(reqDto.getEmail());
        Password password = new Password(reqDto.getPassword());
        User user = new User(reqDto.getUsername(), emailAddress, password);

        authService.registration(user);
        return new ResponseEntity("OK", HttpStatus.OK);
    }
}

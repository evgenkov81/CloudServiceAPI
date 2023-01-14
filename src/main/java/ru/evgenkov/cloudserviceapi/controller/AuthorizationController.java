package ru.evgenkov.cloudserviceapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.evgenkov.cloudserviceapi.model.AuthorizationRequest;
import ru.evgenkov.cloudserviceapi.service.AuthorizationService;

@RestController
@CrossOrigin
@AllArgsConstructor
public class AuthorizationController {
    private final AuthorizationService service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthorizationRequest authorizationRequest) {
        var response = service.login(authorizationRequest);
        if (response == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<?>logout(@RequestHeader("auth-token") String authToken) {
        service.logout(authToken);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
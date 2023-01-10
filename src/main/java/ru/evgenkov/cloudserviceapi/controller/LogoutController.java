package ru.evgenkov.cloudserviceapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.evgenkov.cloudserviceapi.service.AuthorizationService;

public class LogoutController {
    private final AuthorizationService authorizationService;

    public LogoutController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("auth-token") String authToken) {
        authorizationService.logout(authToken);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

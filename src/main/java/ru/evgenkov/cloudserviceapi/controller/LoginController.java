package ru.evgenkov.cloudserviceapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.evgenkov.cloudserviceapi.model.AuthorizationRequest;
import ru.evgenkov.cloudserviceapi.model.AuthorizationResponse;
import ru.evgenkov.cloudserviceapi.service.AuthorizationService;

@RestController
@AllArgsConstructor
public class LoginController {
    private final AuthorizationService authorizationService;

    @PostMapping("/login")
    public AuthorizationResponse login(@RequestBody AuthorizationRequest authorizationRequest) {
        return authorizationService.login(authorizationRequest);
    }


}

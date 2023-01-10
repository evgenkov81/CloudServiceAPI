package ru.evgenkov.cloudserviceapi.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.evgenkov.cloudserviceapi.model.AuthorizationRequest;
import ru.evgenkov.cloudserviceapi.model.AuthorizationResponse;
import ru.evgenkov.cloudserviceapi.repository.AuthorizationRepository;

@Service
@AllArgsConstructor
public class AuthorizationService {
    AuthorizationRepository authorizationRepository;
    public AuthorizationResponse login (AuthorizationRequest authorizationRequest){
        return null;
    }
      public ResponseEntity<?> logout(String authorizationRequest) {
        return null;
    }
}

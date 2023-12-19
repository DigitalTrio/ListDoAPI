package com.digitaltrio.listdoapi.domain.controller;

import com.digitaltrio.listdoapi.Constants;
import com.digitaltrio.listdoapi.data.annotations.CheckForEmptyValues;
import com.digitaltrio.listdoapi.data.services.authenticationService.AuthenticationService;
import com.digitaltrio.listdoapi.data.services.authenticationService.AuthenticationServiceImpl;
import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.domain.requests.authentication.AuthenticateUserRequest;
import com.digitaltrio.listdoapi.domain.responses.user.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = Constants.mainPath + "/authentication")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping()
    @CheckForEmptyValues(AuthenticateUserRequest.class)
    public ResponseEntity<UserResponse> authorizeUser(@RequestBody AuthenticateUserRequest authenticateUserRequest) {
        User user = authenticationService.authenticateUser(authenticateUserRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new UserResponse(user));
    }

}

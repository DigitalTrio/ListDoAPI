package com.digitaltrio.listdoapi.data.services.authenticationService;

import com.digitaltrio.listdoapi.data.exceptions.FalsePasswordException;
import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.data.requests.authentication.AuthenticateUserRequest;
import jakarta.persistence.EntityNotFoundException;

public interface AuthenticationService {
    User authenticateUser(AuthenticateUserRequest authenticateUserRequest) throws EntityNotFoundException, FalsePasswordException;
    Boolean authenticatePassword(String id, String rawPassword) throws EntityNotFoundException, FalsePasswordException;
}

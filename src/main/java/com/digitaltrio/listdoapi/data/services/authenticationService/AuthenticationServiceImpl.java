package com.digitaltrio.listdoapi.data.services.authenticationService;

import com.digitaltrio.listdoapi.Constants;
import com.digitaltrio.listdoapi.data.exceptions.FalsePasswordException;
import com.digitaltrio.listdoapi.data.services.userService.UserServiceImpl;
import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.data.requests.authentication.AuthenticateUserRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(Constants.encodeStrength);
    UserServiceImpl userService;

    @Autowired
    public AuthenticationServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public User authenticateUser(AuthenticateUserRequest authenticateUserRequest) throws EntityNotFoundException, FalsePasswordException {
        try {
            User user = userService.getUserByEmail(authenticateUserRequest.getEmail());
            if(encoder.matches(authenticateUserRequest.getPassword(), user.getPassword())) {
                return user;
            } else {
                throw new FalsePasswordException();
            }
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException(ex);
        }
    }

    @Override
    public Boolean authenticatePassword(String id, String rawPassword) throws EntityNotFoundException {
        try {
            String password = userService.getUser(id).getPassword();
            return encoder.matches(rawPassword, password);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException(ex);
        }
    }
}

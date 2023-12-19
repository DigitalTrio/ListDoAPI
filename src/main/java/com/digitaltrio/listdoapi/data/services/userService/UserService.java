package com.digitaltrio.listdoapi.data.services.userService;

import com.digitaltrio.listdoapi.data.exceptions.EmailNotAvailableException;
import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.domain.requests.user.NewUserRequest;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface UserService {
    User getUser(String id) throws EntityNotFoundException;
    User createUser(NewUserRequest userRequest) throws EmailNotAvailableException;
    void deleteUser(String id) throws EntityNotFoundException;
    List<User> getAllUsers();
    User getUserByEmail(String email) throws EntityNotFoundException;
    Boolean checkForEmailAvailability(String email);
}

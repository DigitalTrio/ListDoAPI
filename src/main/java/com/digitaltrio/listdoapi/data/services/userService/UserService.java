package com.digitaltrio.listdoapi.data.services.userService;

import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.domain.requests.NewUserRequest;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface UserService {
    User getUser(String id) throws EntityNotFoundException;
    User createUser(NewUserRequest userRequest);
    void deleteUser(String id) throws EntityNotFoundException;
    List<User> getAllUsers();
}

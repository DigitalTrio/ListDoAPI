package com.digitaltrio.listdoapi.data.services.userListService;

import com.digitaltrio.listdoapi.domain.entities.UserList;
import com.digitaltrio.listdoapi.domain.requests.user.NewUserRequest;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface UserListService {
    UserList getUser(String id) throws EntityNotFoundException;
    UserList createUser(NewUserRequest userRequest);
    void deleteUser(String id) throws EntityNotFoundException;
    List<UserList> getAllUsers();
}

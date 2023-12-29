package com.digitaltrio.listdoapi.data.services.userListService;

import com.digitaltrio.listdoapi.data.requests.UserList.NewUserListRequest;
import com.digitaltrio.listdoapi.domain.entities.UserList;
import com.digitaltrio.listdoapi.data.requests.user.NewUserRequest;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface UserListService {
    UserList getList(String listID) throws EntityNotFoundException;
    UserList createList(NewUserListRequest newUserListRequest) throws EntityNotFoundException;
    void deleteList(String listID) throws EntityNotFoundException;
    List<UserList> getAllLists();
    List<UserList> getAllUserLists(String userID) throws EntityNotFoundException;
}

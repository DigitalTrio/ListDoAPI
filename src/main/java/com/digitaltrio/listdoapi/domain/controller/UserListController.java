package com.digitaltrio.listdoapi.domain.controller;

import com.digitaltrio.listdoapi.Constants;
import com.digitaltrio.listdoapi.data.annotations.CheckForEmptyValues;
import com.digitaltrio.listdoapi.data.requests.UserList.NewUserListRequest;
import com.digitaltrio.listdoapi.data.responses.userlist.GetAllListsFromUserResponse;
import com.digitaltrio.listdoapi.data.responses.userlist.NewUserListResponse;
import com.digitaltrio.listdoapi.data.responses.userlist.UserListResponse;
import com.digitaltrio.listdoapi.data.services.userListService.UserListServiceImpl;
import com.digitaltrio.listdoapi.domain.entities.UserList;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = Constants.mainPath + "/list")
public class UserListController {

    UserListServiceImpl userListService;

    @Autowired
    public UserListController(UserListServiceImpl userListService) {
        this.userListService = userListService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserListResponse> getList(@PathVariable String id) {
        UserList userList = userListService.getList(id);
        return ResponseEntity.status(HttpStatus.OK).body(new UserListResponse(userList));
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<GetAllListsFromUserResponse> getAllListsFromUser(@PathVariable String id) {
        List<UserList> userLists = userListService.getAllUserLists(id);
        return ResponseEntity.status(HttpStatus.OK).body(new GetAllListsFromUserResponse(userLists));
    }

    @PostMapping
    @CheckForEmptyValues(NewUserListResponse.class)
    public ResponseEntity<NewUserListResponse> createNewList(@RequestBody NewUserListRequest newUserListRequest) {
        UserList userList = userListService.createList(newUserListRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new NewUserListResponse(userList));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<> deleteList(@PathVariable String id)
}

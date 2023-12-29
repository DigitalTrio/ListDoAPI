package com.digitaltrio.listdoapi.domain.controller;

import com.digitaltrio.listdoapi.Constants;
import com.digitaltrio.listdoapi.data.annotations.CheckForEmptyValues;
import com.digitaltrio.listdoapi.data.services.userService.UserServiceImpl;
import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.data.requests.user.NewUserRequest;
import com.digitaltrio.listdoapi.data.responses.user.GetAllUserResponse;
import com.digitaltrio.listdoapi.data.responses.user.NewUserResponse;
import com.digitaltrio.listdoapi.data.responses.user.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = Constants.mainPath + "/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping()
    @CheckForEmptyValues(NewUserRequest.class)
    public ResponseEntity<NewUserResponse> createNewUser(@RequestBody NewUserRequest newUserRequest) {
        // TODO : Nach API Key abfragen
        User user = userService.createUser(newUserRequest);
        logger.info("New User Created");
        return ResponseEntity.status(HttpStatus.CREATED).body(new NewUserResponse(user));
    }

    @GetMapping()
    public ResponseEntity<GetAllUserResponse> getAllUsers() {
        GetAllUserResponse getAllUserResponse = new GetAllUserResponse(userService.getAllUsers());
        logger.info("Returned All Users");
        return ResponseEntity.status(HttpStatus.OK).body(getAllUserResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String id) {
        User user = userService.getUser(id);
        logger.info("Returned User:" + id);
        return ResponseEntity.status(HttpStatus.OK).body(new UserResponse(user));

    }
}

package com.digitaltrio.listdoapi.domain.controller;

import com.digitaltrio.listdoapi.Constants;
import com.digitaltrio.listdoapi.data.annotations.CheckForEmptyValues;
import com.digitaltrio.listdoapi.data.services.userService.UserService;
import com.digitaltrio.listdoapi.data.services.userService.UserServiceImpl;
import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.domain.requests.NewUserRequest;
import com.digitaltrio.listdoapi.domain.responses.error.BadRequestErrorResponse;
import com.digitaltrio.listdoapi.domain.responses.error.EmptyValueErrorResponse;
import com.digitaltrio.listdoapi.domain.responses.error.NotFoundResponse;
import com.digitaltrio.listdoapi.domain.responses.user.GetAllUserResponse;
import com.digitaltrio.listdoapi.domain.responses.user.NewUserResponse;
import com.digitaltrio.listdoapi.domain.responses.user.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> getUser(@PathVariable String id) {
        try {
            User user = userService.getUser(id);
            logger.info("Returned User");
            return ResponseEntity.status(HttpStatus.OK).body(new UserResponse(user));
        } catch (EntityNotFoundException ex) {
            logger.warn(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundResponse(ex.getMessage()));
        }
    }
}

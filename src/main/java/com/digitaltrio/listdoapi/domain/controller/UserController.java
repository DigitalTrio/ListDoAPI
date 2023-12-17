package com.digitaltrio.listdoapi.domain.controller;

import com.digitaltrio.listdoapi.Constants;
import com.digitaltrio.listdoapi.data.annotations.CheckForEmptyValues;
import com.digitaltrio.listdoapi.data.services.userService.UserService;
import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.domain.requests.NewUserRequest;
import com.digitaltrio.listdoapi.domain.responses.error.BadRequestErrorResponse;
import com.digitaltrio.listdoapi.domain.responses.error.EmptyValueErrorResponse;
import com.digitaltrio.listdoapi.domain.responses.user.NewUserResponse;
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
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
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
}

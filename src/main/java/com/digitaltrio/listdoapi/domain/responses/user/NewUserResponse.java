package com.digitaltrio.listdoapi.domain.responses.user;

import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.domain.requests.NewUserListRequest;
import com.digitaltrio.listdoapi.domain.requests.NewUserRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class NewUserResponse {
    int statusCode = HttpStatus.CREATED.value();
    String message = "User created successfully!";
    Map<String, String> userCredentials = new HashMap<>();

    public NewUserResponse(User user) {
        userCredentials.put("id", user.getId());
        userCredentials.put("username", user.getUsername());
        userCredentials.put("email", user.getEmail());
        userCredentials.put("password", user.getPassword());
        userCredentials.put("created_at", user.getFormattedCreationTime());
    }
}

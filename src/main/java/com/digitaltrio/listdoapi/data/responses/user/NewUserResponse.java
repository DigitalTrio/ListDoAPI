package com.digitaltrio.listdoapi.data.responses.user;

import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.data.responses.APIResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class NewUserResponse extends APIResponse {
    private final static int statusCode = HttpStatus.CREATED.value();
    private final static String message = "User created successfully!";
    Map<String, String> userCredentials = new HashMap<>();

    public NewUserResponse(User user) {
        super(statusCode, message);
        userCredentials.put("id", user.getId());
        userCredentials.put("username", user.getUsername());
        userCredentials.put("email", user.getEmail());
        userCredentials.put("password", user.getPassword());
        userCredentials.put("created_at", user.getFormattedCreationTime());
    }
}

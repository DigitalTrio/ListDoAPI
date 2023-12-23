package com.digitaltrio.listdoapi.data.responses.user;

import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.data.responses.APIResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResponse extends APIResponse {
    private static final int statusCode = HttpStatus.OK.value();
    private static final String message = "User successfully fetched";
    Map<String, String> userCredentials = new HashMap<>();

    public UserResponse(User user) {
        super(statusCode, message);
        userCredentials.put("id", user.getId());
        userCredentials.put("username", user.getUsername());
        userCredentials.put("email", user.getEmail());
        userCredentials.put("password", user.getPassword());
        userCredentials.put("created_at", user.getFormattedCreationTime());
    }
}

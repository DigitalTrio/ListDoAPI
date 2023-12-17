package com.digitaltrio.listdoapi.domain.responses.user;

import com.digitaltrio.listdoapi.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetAllUserResponse {
    private int statusCode = HttpStatus.OK.value();
    private String message = "Successfully loaded all Users";
    private int amount;
    private List<UserResponse> allUsers = new ArrayList<>();

    public GetAllUserResponse(List<User> users) {
        for(User user : users) {
            allUsers.add(new UserResponse(user));
        }
        amount = users.size();
    }
}

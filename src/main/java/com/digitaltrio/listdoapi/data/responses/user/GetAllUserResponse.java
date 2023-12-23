package com.digitaltrio.listdoapi.data.responses.user;

import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.data.responses.APIResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetAllUserResponse extends APIResponse {
    private final static int statusCode = HttpStatus.OK.value();
    private final static String message = "Successfully loaded all Users";
    private int amount;
    private List<UserResponse> allUsers = new ArrayList<>();

    public GetAllUserResponse(List<User> users) {
        super(statusCode, message);
        for(User user : users) {
            allUsers.add(new UserResponse(user));
        }
        amount = users.size();
    }
}

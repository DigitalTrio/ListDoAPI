package com.digitaltrio.listdoapi.data.responses.userlist;

import com.digitaltrio.listdoapi.data.responses.APIResponse;
import com.digitaltrio.listdoapi.domain.entities.UserList;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GetAllListsFromUserResponse extends APIResponse {
    private static final int statusCode = HttpStatus.OK.value();
    private static final String message = "Successfully fetched all Lists";
    private int amount;
    List<UserListResponse> lists = new ArrayList<>();

    public GetAllListsFromUserResponse(List<UserList> userLists) {
        super(statusCode, message);
        this.amount = userLists.size();
        for(UserList userList : userLists) {
            this.lists.add(new UserListResponse(userList));
        }
    }
}

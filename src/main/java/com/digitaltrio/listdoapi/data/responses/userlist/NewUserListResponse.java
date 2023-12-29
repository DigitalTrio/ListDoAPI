package com.digitaltrio.listdoapi.data.responses.userlist;

import com.digitaltrio.listdoapi.data.responses.APIResponse;
import com.digitaltrio.listdoapi.domain.entities.UserList;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class NewUserListResponse extends APIResponse {
    private static final int statusCode = HttpStatus.CREATED.value();
    private static final String message = "List successfully created";
    private UserListResponse list;

    public NewUserListResponse(UserList userList) {
        super(statusCode, message);
        this.list = new UserListResponse(userList);
    }
}

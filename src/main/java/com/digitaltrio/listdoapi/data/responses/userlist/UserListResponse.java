package com.digitaltrio.listdoapi.data.responses.userlist;

import com.digitaltrio.listdoapi.data.responses.APIResponse;
import com.digitaltrio.listdoapi.data.responses.user.UserResponse;
import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.domain.entities.UserList;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserListResponse extends APIResponse {
    private static final int statusCode = HttpStatus.OK.value();
    private static final String message = "List successfully fetched";
    private String id;
    private String listName;
    private LocalDateTime created_at;
    private String owner_id;
    List<UserResponse> members = new ArrayList<>();

    public UserListResponse(UserList userList) {
        super(statusCode, message);
        this.id = userList.getId();
        this.listName = userList.getListName();
        this.created_at = userList.getCreated_at();
        this.owner_id = userList.getOwnerID();
        if(userList.getMembers() != null) {
            for(User user : userList.getMembers()) {
                members.add(new UserResponse(user));
            }
        }
    }
}

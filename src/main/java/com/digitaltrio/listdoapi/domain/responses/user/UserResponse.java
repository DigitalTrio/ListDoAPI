package com.digitaltrio.listdoapi.domain.responses.user;

import com.digitaltrio.listdoapi.domain.entities.User;
import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private String password;
    private String created_at;

    public UserResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.created_at = user.getFormattedCreationTime();
    }
}

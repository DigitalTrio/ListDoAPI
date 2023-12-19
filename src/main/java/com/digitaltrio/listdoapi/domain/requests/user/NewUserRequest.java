package com.digitaltrio.listdoapi.domain.requests.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUserRequest {
    private String username;
    private String password;
    private String email;
}

package com.digitaltrio.listdoapi.data.requests.authentication;

import lombok.Data;

@Data
public class AuthenticateUserRequest {
    private String email;
    private String password;
}

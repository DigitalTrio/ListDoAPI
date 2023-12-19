package com.digitaltrio.listdoapi.domain.requests.authentication;

import lombok.Data;

@Data
public class AuthenticateUserRequest {
    private String email;
    private String password;
}

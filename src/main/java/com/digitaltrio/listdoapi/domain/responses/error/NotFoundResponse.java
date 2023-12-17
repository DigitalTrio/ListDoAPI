package com.digitaltrio.listdoapi.domain.responses.error;

import com.digitaltrio.listdoapi.domain.entities.User;
import com.digitaltrio.listdoapi.domain.responses.user.UserResponse;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NotFoundResponse {
    private int statusCode = HttpStatus.NOT_FOUND.value();
    private String message;

    public NotFoundResponse(String message) {
        this.message = message;
    }
}

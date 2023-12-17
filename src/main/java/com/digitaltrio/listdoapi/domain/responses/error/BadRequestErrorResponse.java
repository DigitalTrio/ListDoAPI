package com.digitaltrio.listdoapi.domain.responses.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class BadRequestErrorResponse {
    int statusCode = HttpStatus.BAD_REQUEST.value();
    LocalDateTime timestamp = LocalDateTime.now();
    String message = "One or more Values are missing!";
    List<String> missingArgs = new ArrayList<>();

    public BadRequestErrorResponse(List<String> missingArgs) {
        this.missingArgs.addAll(missingArgs);
    }
}

package com.digitaltrio.listdoapi.domain.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract public class APIResponse {
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;

    public APIResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        timestamp = LocalDateTime.now();
    }
}

package com.digitaltrio.listdoapi.data.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract public class APIResponse {
    private int statusCode;
    private String message;
    private String timestamp;

    public APIResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        timestamp = getFormattedCreationTime(LocalDateTime.now());
    }

    private String getFormattedCreationTime(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }
}

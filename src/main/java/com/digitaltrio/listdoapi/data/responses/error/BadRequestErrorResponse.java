package com.digitaltrio.listdoapi.data.responses.error;

import com.digitaltrio.listdoapi.data.responses.APIResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BadRequestErrorResponse extends APIResponse {
    private final static int statusCode = HttpStatus.BAD_REQUEST.value();
    LocalDateTime timestamp = LocalDateTime.now();
    private final static String message = "One or more Values are missing!";
    List<String> missingArgs = new ArrayList<>();

    public BadRequestErrorResponse(List<String> missingArgs) {
        super(statusCode, message);
        this.missingArgs.addAll(missingArgs);
    }
}

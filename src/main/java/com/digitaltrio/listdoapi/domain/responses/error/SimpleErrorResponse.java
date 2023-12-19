package com.digitaltrio.listdoapi.domain.responses.error;

import com.digitaltrio.listdoapi.domain.responses.APIResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class SimpleErrorResponse extends APIResponse {
    private static final int statusCode = HttpStatus.CONFLICT.value();

    public SimpleErrorResponse(String message) {
        super(statusCode, message);
    }
}

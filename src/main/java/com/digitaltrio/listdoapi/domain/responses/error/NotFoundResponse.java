package com.digitaltrio.listdoapi.domain.responses.error;

import com.digitaltrio.listdoapi.domain.responses.APIResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = false)
@Data
public class NotFoundResponse extends APIResponse {
    private static final int statusCode = HttpStatus.NOT_FOUND.value();
    public NotFoundResponse(String message) {
        super(statusCode, message);
    }
}

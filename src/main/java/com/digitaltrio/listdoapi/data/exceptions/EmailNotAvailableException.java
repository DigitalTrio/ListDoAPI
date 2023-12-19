package com.digitaltrio.listdoapi.data.exceptions;

public class EmailNotAvailableException extends RuntimeException{
    public EmailNotAvailableException(String message) {
        super(message);
    }

    public EmailNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
